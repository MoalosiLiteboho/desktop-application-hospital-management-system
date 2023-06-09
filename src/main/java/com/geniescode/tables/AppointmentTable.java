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

public class AppointmentTable extends Panel {
    private Table appointmentTable;
    private JScrollPane scrollPane;

    public AppointmentTable() {
        initComponents();
        initTable();
    }

    private void initTable() {
        appointmentTable.fixTable(scrollPane);
    }

    private void initComponents() {
        JLabel tittle = new JLabel("Appointment Table");
        Panel tablePanel = new Panel();
        scrollPane = new JScrollPane();
        appointmentTable = new Table();

        appointmentTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {"#", "Name", "Email", "Position", "Date Join"}) {
            final boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        scrollPane.setViewportView(appointmentTable);

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
