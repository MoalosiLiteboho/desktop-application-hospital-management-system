package com.geniescode.share.components.table;

import com.geniescode.share.components.scroll.ScrollBar;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.Color;
import java.awt.Component;
import java.util.function.Consumer;

public class Table extends JTable {

    public Table() {
        initComponents();
    }

    private void initComponents() {
        setShowHorizontalLines(true);
        setShowVerticalLines(false);
        setGridColor(Color.lightGray);
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object object, boolean bln, boolean bln1, int i, int i1) {
                return new TableHeader(object + "");
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object object, boolean selected, boolean bln1, int i, int i1) {
                Component component = super.getTableCellRendererComponent(table, object, selected, bln1, i, i1);
                component.setBackground(Color.white);
                setBorder(noFocusBorder);
                if (selected)
                    component.setForeground(Color.green);
                else
                    component.setForeground(Color.gray);
                return component;
            }
        });
    }

    public Consumer <Object[]> addRowIntoTable = row -> {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    };

    public void searchStringOnTable(String searchedWord) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        TableRowSorter <DefaultTableModel> tableRows = new TableRowSorter<>(model);
        setRowSorter(tableRows);
        tableRows.setRowFilter(RowFilter.regexFilter(searchedWord));
    }

    public Consumer <JScrollPane> setTableFeelGood = scroll -> {
        JPanel panel = new JPanel();

        panel.setBackground(Color.white);

        scroll.setBorder(null);
        scroll.setVerticalScrollBar(new ScrollBar());
        scroll.getVerticalScrollBar().setBackground(Color.white);
        scroll.getViewport().setBackground(Color.white);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
    };

    public void clearTableData() {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.getDataVector().removeAllElements();
        revalidate();
    }
}
