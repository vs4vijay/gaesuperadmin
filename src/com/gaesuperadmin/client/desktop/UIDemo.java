package com.gaesuperadmin.client.desktop;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class UIDemo {
  public static void main(String args[]) {
    Object rows[][] = { { "one", "ichi - \u4E00" },
        { "two", "ni - \u4E8C" }, { "three", "san - \u4E09" },
        { "four", "shi - \u56DB" }, { "five", "go - \u4E94" },
        { "six", "roku - \u516D" }, { "seven", "shichi - \u4E03" },
        { "eight", "hachi - \u516B" }, { "nine", "kyu - \u4E5D" },
        { "ten", "ju - \u5341" } };
    Object headers[] = { "English", "Japanese" };
    JFrame frame = new JFrame("Tooltip Sample");
    JTable table = new JTable(rows, headers);

    JLabel headerRenderer = new DefaultTableCellRenderer();
    String columnName = table.getModel().getColumnName(0);
    headerRenderer.setText(columnName);
    headerRenderer.setToolTipText("Wave");
    TableColumnModel columnModel = table.getColumnModel();
    TableColumn englishColumn = columnModel.getColumn(0);
    englishColumn.setHeaderRenderer((TableCellRenderer) headerRenderer);

    JScrollPane scrollPane = new JScrollPane(table);
    frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
    frame.setSize(300, 150);
    frame.setVisible(true);
  }
}