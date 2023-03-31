package com.geniescode.appointment;

import com.geniescode.share.components.comboBox.ComboBox;
import com.geniescode.share.components.panel.Panel;
import com.geniescode.share.components.textField.TextField;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class AppointmentBookingPanel extends Panel {
    private ComboBox<String> patient;
    private ComboBox<String> doctors;
    public AppointmentBookingPanel() {
        initComponents();
    }

    private void initComponents() {
        JLabel tittle = new JLabel("Booking Appointment");


        tittle.setFont(tittle.getFont().deriveFont(Font.PLAIN, 25));
        tittle.setHorizontalAlignment(SwingConstants.CENTER);
        tittle.setForeground(Color.green);

        setLayout(new MigLayout("inset 0, gap 0, wrap"));
        add(tittle, "width 100%, gap top 20px");
        setFont(new Font("sanserif", Font.PLAIN, 15));
        setBackground(Color.white);
    }
}
