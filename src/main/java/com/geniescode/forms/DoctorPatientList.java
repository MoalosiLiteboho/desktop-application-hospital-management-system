package com.geniescode.forms;

import com.geniescode.share.components.panel.Panel;
import com.geniescode.share.components.table.Table;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DoctorPatientList extends Panel {
    private Table patientTable;
    private JScrollPane scrollPane;
    private final int doctorId;

    public DoctorPatientList(int doctorId) {
        this.doctorId = doctorId;
        initComponents();
        initTable();
    }

    private void initComponents() {
        JLabel tittle = new JLabel("Patient List");
        patientTable = new Table();
        scrollPane =new JScrollPane();
        Panel tablePanel = new Panel();


        patientTable.setModel(new DefaultTableModel(
                new Object [][] {},
                new String [] {"#", "Name", "Surname", "Gender", "Date Of Birth",  "Email", "Authority", "Action"}) {
            final boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        scrollPane.setViewportView(patientTable);

        tittle.setFont(tittle.getFont().deriveFont(Font.PLAIN, 25));
        tittle.setHorizontalAlignment(SwingConstants.CENTER);
        tittle.setForeground(Color.green);

        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(scrollPane);
        tablePanel.setBackground(Color.white);
        tablePanel.setBottomLine(Color.green, new Color(0x6600FF00, true));

        setLayout(new MigLayout("inset 0, gap 0, wrap"));
        add(tittle, "width 100%, gap top 25px, gap bottom 25px");
        add(tablePanel, "gap left 30px, gap right 30px, gap bottom 40px, width 100%, height 100%");
        setFont(new Font("sanserif", Font.PLAIN, 15));
        setBackground(Color.white);
    }

    private void initTable() {
        patientTable.fixTable(scrollPane);
    }

    private void populateTable() {

    }
}
