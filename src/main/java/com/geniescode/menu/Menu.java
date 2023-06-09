package com.geniescode.menu;

import com.geniescode.share.components.scroll.ScrollBar;
import javaswingdev.GoogleMaterialDesignIcon;
import javaswingdev.GoogleMaterialIcon;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

public class Menu extends JPanel {
    private final Animator animator;
    private MenuButton selectedMenu;
    private MenuButton unSelectedMenu;
    private MenuEvent event;

    public Menu() {
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        JScrollPane scroll = createScroll();
        panelMenu = createPanelMenu();
        scroll.setViewportView(panelMenu);
        scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
        add(scroll);

        TimingTarget target = new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction) {
                selectedMenu.setAnimate(fraction);
                if (unSelectedMenu != null)
                    unSelectedMenu.setAnimate(1f - fraction);
            }
        };
        animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
    }

    public void initAmin(MenuEvent event, String userName) {
        this.event = event;
        addTitle("ADMIN");
        addTitle(userName);
        addTitle("Home Page");
        addMenu("Dashboard", GoogleMaterialDesignIcon.DASHBOARD, "Dashboard");
        addMenu("My Profile", GoogleMaterialDesignIcon.PERSON, "Profile");
        addMenu("Users List", GoogleMaterialDesignIcon.LIST, "UsersList");
        addMenu("Appointments List", GoogleMaterialDesignIcon.LIST, "AdminAppointments");
        addMenu("LogOut", GoogleMaterialDesignIcon.ARROW_BACK, "LogOut");
    }
    public void initDoctor(MenuEvent event, String userName) {
        this.event = event;
        addTitle("DOCTOR");
        addTitle(userName);
        addMenu("Dashboard", GoogleMaterialDesignIcon.DASHBOARD, "Dashboard");
        addMenu("My Profile", GoogleMaterialDesignIcon.PERSON, "Profile");
        addMenu("Patient List", GoogleMaterialDesignIcon.LIST, "DoctorPatientList");
        addMenu("Appointments List", GoogleMaterialDesignIcon.LIST, "DoctorAppointments");
        addMenu("LogOut", GoogleMaterialDesignIcon.ARROW_BACK, "LogOut");
    }

    public void initReceptionist(MenuEvent event, String userName) {
        this.event = event;
        addTitle("RECEPTIONIST");
        addTitle(userName);
        addMenu("Dashboard", GoogleMaterialDesignIcon.DASHBOARD, "Dashboard");
        addMenu("My Profile", GoogleMaterialDesignIcon.PERSON, "Profile");
        addMenu("All Appointments", GoogleMaterialDesignIcon.LIST, "ReceptionistAppointment");
        addMenu("LogOut", GoogleMaterialDesignIcon.ARROW_BACK, "LogOut");
    }

    public void initPatient(MenuEvent event, String userName) {
        this.event = event;
        addTitle("PATIENT");
        addTitle(userName);
        addMenu("Dashboard", GoogleMaterialDesignIcon.DASHBOARD, "Dashboard");
        addMenu("My Profile", GoogleMaterialDesignIcon.PERSON, "Profile");
        addMenu("Appointments", GoogleMaterialDesignIcon.LIST, "PatientAppointments");
        addMenu("LogOut", GoogleMaterialDesignIcon.ARROW_BACK, "LogOut");
    }



    private void addMenu (String label, GoogleMaterialDesignIcon icon, String menuName) {
        MenuButton menu = new MenuButton();
        menu.setIcon(new GoogleMaterialIcon(icon, null, Color.gray, Color.gray, 20).toIcon());
        setFont(menu.getFont().deriveFont(Font.PLAIN, 14));
        menu.setText(label);

        menu.addActionListener(event -> {
            if (!animator.isRunning())
                if (menu != selectedMenu) {
                    unSelectedMenu = selectedMenu;
                    selectedMenu = menu;
                    animator.start();
                    this.event.menuSelected(menuName);
                }
        });
        panelMenu.add(menu);
    }

    private JScrollPane createScroll() {
        JScrollPane scroll = new JScrollPane();

        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBar(new ScrollBar());

        return scroll;
    }

    private JPanel createPanelMenu() {
        JPanel panel = new JPanel();

        panel.setOpaque(false);
        panel.setLayout(new MigLayout("wrap,fillx,inset 0,gapy 0", "[fill]"));

        return panel;
    }

    public void addTitle(String title) {
        JLabel label = new JLabel(title);

        label.setBorder(new EmptyBorder(15, 20, 5, 5));
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        label.setForeground(new Color(170, 170, 170));

        panelMenu.add(label);
    }

    private final JPanel panelMenu;
}
