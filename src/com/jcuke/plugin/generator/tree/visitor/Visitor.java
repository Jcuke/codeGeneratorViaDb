package com.jcuke.plugin.generator.tree.visitor;

import com.jcuke.plugin.generator.tree.*;
import com.jcuke.plugin.generator.tree.Class;

public interface Visitor {

  void visit(com.jcuke.plugin.generator.tree.Package aPackage);

  void visit(Import anImport);

  void visit(Class aClass);

  void visit(Field field);
}
