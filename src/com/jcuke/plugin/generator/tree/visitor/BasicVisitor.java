package com.jcuke.plugin.generator.tree.visitor;

import com.jcuke.plugin.entity.Table;
import com.jcuke.plugin.generator.config.TablesConfig;
import com.jcuke.plugin.generator.tree.Element;
import com.jcuke.plugin.generator.tree.*;

public class BasicVisitor extends VisitorSupport {

  public BasicVisitor(Table table, TablesConfig tablesConfig) {
    super(table, tablesConfig);
  }

  @Override
  public void visit(com.jcuke.plugin.generator.tree.Class aClass) {
    super.visit(aClass);
  }

  @Override
  public void visit(Field field) {
    super.visit(field);
    if (!field.getFieldName().equals(Element.SERIAL_VERSION_UID)) {
      field.setHasDefaultValue(false);
    }
  }
}
