package com.geniescode.forms;

import com.geniescode.share.components.panel.Panel;
import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class DashboardForm extends Panel {
    public DashboardForm() {
        initComponents();
    }

    private void initComponents() {
        JLabel tittle = new JLabel("Dashboard");

        tittle.setHorizontalAlignment(SwingConstants.CENTER);
        tittle.setFont(tittle.getFont().deriveFont(Font.PLAIN, 25));
        tittle.setForeground(Color.green);

        setLayout(new MigLayout("inset 0, gap 0, wrap"));
        add(tittle, "width 100%, gap top 25px");
        setFont(new Font("sanserif", Font.PLAIN, 15));
        setBackground(Color.white);
    }
}
