package com.geniescode.forms;

import com.geniescode.share.components.panel.Panel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class PatientAppointments extends Panel {
    public PatientAppointments() {
        initComponents();
    }

    private void initComponents() {
        JLabel tittle = new JLabel("My Appointments");

        tittle.setHorizontalAlignment(SwingConstants.CENTER);
        tittle.setFont(tittle.getFont().deriveFont(Font.PLAIN, 25));
        tittle.setForeground(Color.green);

        setLayout(new MigLayout("inset 0, wrap, gap 0"));
        add(tittle, "width 100%, gap top 25px");
        setFont(new Font("sanserif", Font.PLAIN, 15));
        setBackground(Color.white);
    }
}
