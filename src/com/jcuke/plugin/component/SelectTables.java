package com.jcuke.plugin.component;

import com.jcuke.plugin.entity.Table;

import javax.swing.*;
import java.util.List;

public class SelectTables {

  private JTable tblTableSchema;
  private JPanel rootComponent;
  private JButton btnSelectOther;
  private JButton btnSelectAll;
  private JButton btnSelectNone;
  private JButton btnCancel;
  private JButton btnGenerate;
  private final List<Table> tableList;

  public SelectTables(List<Table> tableList) {
    this.tableList = tableList;
  }

  public JTable getTblTableSchema() {
    return tblTableSchema;
  }

  public JPanel getRootComponent() {
    return rootComponent;
  }

  public JButton getBtnSelectOther() {
    return btnSelectOther;
  }

  public JButton getBtnSelectAll() {
    return btnSelectAll;
  }

  public JButton getBtnSelectNone() {
    return btnSelectNone;
  }

  public JButton getBtnCancel() {
    return btnCancel;
  }

  public JButton getBtnGenerate() {
    return btnGenerate;
  }

  public List<Table> getTableList() {
    return tableList;
  }
}
