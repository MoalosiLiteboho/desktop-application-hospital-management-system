package com.geniescode.dashboard;

import com.geniescode.forms.AdminAppointments;
import com.geniescode.forms.DashboardForm;
import com.geniescode.forms.DoctorAppointments;
import com.geniescode.forms.DoctorPatientList;
import com.geniescode.forms.PatientAppointments;
import com.geniescode.forms.ReceptionistAppointment;
import com.geniescode.forms.UsersList;
import com.geniescode.share.components.panel.Panel;
import com.geniescode.userProfile.UserProfile;

public class DashboardService {
    private final Panel bodyPanel;
    private final DashboardFrame frame;

    public DashboardService(DashboardFrame dashboardFrame) {
        frame = dashboardFrame;
        bodyPanel = frame.getRightSide();
    }

    public void menuSelected(String menuName) {
        switch (menuName) {
            case "Dashboard" -> addForm(new DashboardForm());
            case "UsersList" -> addForm(new UsersList());
            case "DoctorPatientList" -> addForm(new DoctorPatientList());
            case "Profile" -> addForm(new UserProfile(frame.getUserId()));
            case "AdminAppointments" -> addForm(new AdminAppointments());
            case "DoctorAppointments" -> addForm(new DoctorAppointments());
            case "ReceptionistAppointment" -> addForm(new ReceptionistAppointment());
            case "PatientAppointments" -> addForm(new PatientAppointments());
            case "LogOut" -> System.exit(0);
            default -> throw new RuntimeException("Menu error");
        }
    }

    private void addForm(Panel panelForm) {
        bodyPanel.removeAll();
        bodyPanel.add(panelForm);
        bodyPanel.validate();
        bodyPanel.repaint();
    }
}
