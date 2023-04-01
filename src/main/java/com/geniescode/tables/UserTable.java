package com.geniescode.tables;

import com.geniescode.share.components.panel.Panel;
import com.geniescode.share.components.table.Table;
import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

public class UserTable extends Panel {
    private Table userTable;
    private JScrollPane scrollPane;

    public UserTable() {
        initComponents();
        initTable();
    }

    private void initTable() {
        userTable.fixTable(scrollPane);
    }

    private void initComponents() {
        Panel tablePanel = new Panel();
        JLabel tittle = new JLabel("User Table");
        scrollPane = new JScrollPane();
        userTable = new Table();

        userTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {"#", "Name", "Surname", "Gender", "Date Of Birth",  "Email", "Action"}) {
            final boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        scrollPane.setViewportView(userTable);

        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(scrollPane);

        tittle.setHorizontalAlignment(SwingConstants.CENTER);
        tittle.setFont(tittle.getFont().deriveFont(Font.PLAIN, 25));
        tittle.setForeground(Color.green);

        setLayout(new MigLayout("inset 0, gap 0, wrap"));
        add(tittle, "width 100%, gap top 25px");
        add(tablePanel, "gap left  20px, gap right 20px, width 100%, gap top 25px, gap bottom 25px, height 100%");
        setBackground(Color.white);
        setFont(new Font("sanserif", Font.PLAIN, 15));
    }
}
