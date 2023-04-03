package com.geniescode.forms;

import com.geniescode.share.components.panel.Panel;
import com.geniescode.share.components.table.Table;
import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

public class DoctorAppointments extends Panel {
    private Table appointmentTable;
    private JScrollPane scrollPane;

    public DoctorAppointments() {
        initComponents();
        initTable();
    }

    private void initComponents() {
        Panel tablePanel = new Panel();
        JLabel tittle = new JLabel("Doctor Appointments List");
        appointmentTable = new Table();
        scrollPane = new JScrollPane();

        appointmentTable.setModel(new DefaultTableModel(
                new Object [][] {},
                new String [] {"#", "Patient Names", "Status", "Creation Date", "Appointment Date", "Action"}) {
            final boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        scrollPane.setViewportView(appointmentTable);

        tittle.setHorizontalAlignment(SwingConstants.CENTER);
        tittle.setFont(tittle.getFont().deriveFont(Font.PLAIN, 25));
        tittle.setForeground(Color.green);

        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(scrollPane);
        tablePanel.setBottomLine(Color.green, new Color(0x6600FF00, true));
        tablePanel.setBackground(Color.white);

        setLayout(new MigLayout("inset 0, gap 0, wrap"));
        add(tittle, "width 100%, gap top 25px, gap bottom 25px");
        add(tablePanel, "gap left 30px, gap right 30px, gap bottom 40px, width 100%, height 100%");
        setFont(new Font("sanserif", Font.PLAIN, 15));
        setBackground(Color.white);
    }

    private void initTable() {
        appointmentTable.fixTable(scrollPane);
    }
}
