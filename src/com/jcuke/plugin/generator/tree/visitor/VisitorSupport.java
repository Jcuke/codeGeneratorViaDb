package com.jcuke.plugin.generator.tree.visitor;

import com.jcuke.plugin.entity.Table;
import com.jcuke.plugin.generator.config.TablesConfig;
import com.jcuke.plugin.generator.tree.Element;
import com.jcuke.plugin.generator.tree.EntitySourceFile;
import com.jcuke.plugin.generator.tree.Extends;
import com.jcuke.plugin.generator.tree.Field;
import com.jcuke.plugin.generator.tree.Import;
import com.jcuke.plugin.generator.tree.Class;

import java.io.Serializable;

public class VisitorSupport implements Visitor {

  protected Import anImport;
  protected final Table table;
  protected final TablesConfig tablesConfig;

  public VisitorSupport(Table table, TablesConfig tablesConfig) {
    this.table = table;
    this.tablesConfig = tablesConfig;
  }

  @Override
  public void visit(com.jcuke.plugin.generator.tree.Package aPackage) {

  }

  @Override
  public void visit(Import anImport) {
    this.anImport = anImport;
  }

  @Override
  public void visit(Class aClass) {
    if (anImport == null) {
      anImport = ((EntitySourceFile) aClass.parent()).getAnImport();
    }
    if (aClass.getAnImplements().contains(Serializable.class)) {
      Field uidField = new Field(Element.SERIAL_VERSION_UID, long.class, false);
      uidField.setModifiers("private static final");
      uidField.setDefaultValue("1L");
      uidField.setHasDefaultValue(true);
      aClass.addChild(uidField);
    }
    aClass.getAnImplements().getImplementSet().forEach(anImport::addImportClass);
    Extends anExtends = aClass.getAnExtends();
    if (anExtends != null && !anExtends.getPackageName().isEmpty() &&
        !anExtends.getPackageName().equals(table.getPackageName())) {
      anImport.addImportClass(anExtends.getPackageName() + "." + anExtends.getEntityName());
    }
  }

  @Override
  public void visit(Field field) {
    if (anImport == null) {
      anImport = (Import) field.parent().siblings("import").get(0);
    }
    anImport.addImportClass(field.getDataType().getName());
  }
}
