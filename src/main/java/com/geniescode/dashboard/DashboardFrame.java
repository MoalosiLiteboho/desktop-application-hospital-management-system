package com.geniescode.dashboard;

import com.geniescode.appointment.AppointmentBookedByReceptionistPanel;
import com.geniescode.share.components.panel.Panel;
import com.geniescode.share.components.tittleBar.TittleBarPanel;
import com.geniescode.userProfile.UserProfile;
import net.miginfocom.swing.MigLayout;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class DashboardFrame extends JFrame {
    public DashboardFrame() {
        initComponents();
    }

    private void initComponents() {
        Panel background = new Panel();
        Panel leftSide = new Panel();
        Panel rightSide = new Panel();

        rightSide.setLayout(new BorderLayout());
        rightSide.add(new AppointmentBookedByReceptionistPanel());
        rightSide.setBackground(Color.white);

        leftSide.setLayout(new MigLayout("inset 0, gap 0, wrap"));
        leftSide.add(new TittleBarPanel(this), "width 100%, height 70px");
//        leftSide.add(menuPanel, "width 100%, height 100%");
        leftSide.setBackground(Color.white);

        background.setLayout(new MigLayout("inset 0px, gap 0px, filly"));
        background.add(leftSide, "gap right 1px, width 500px, height 100%");
        background.add(rightSide, "width 100%, height 100%");
        background.setBackground(Color.green);

        setLayout(new BorderLayout());
        add(background);
        setBackground(Color.white);
        setUndecorated(true);
        setSize(new Dimension(1_000, 600));
        setLocationRelativeTo(null);
    }
}
