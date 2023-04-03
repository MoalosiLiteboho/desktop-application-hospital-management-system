package com.geniescode.dashboard;

import com.geniescode.menu.MenuEvent;
import com.geniescode.user.GetUserById;
import com.geniescode.user.User;

public class DashboardController implements MenuEvent {
    private final DashboardFrame dashboardFrame;
    private final DashboardService service;
    private final int userId;

    public DashboardController(DashboardFrame dashboardFrame, int userId) {
        this.dashboardFrame = dashboardFrame;
        this.userId = userId;
        service = new DashboardService(this.dashboardFrame);
        init();
    }

    private void init() {
        User user = new GetUserById().apply(userId);
        switch (user.authority()) {
            case "Admin" -> dashboardFrame.getMenu().initAmin(this, user.name() + " " + user.surname());
            case "Doctor" -> dashboardFrame.getMenu().initDoctor(this, user.name() + " " + user.surname());
            case "Receptionist" -> dashboardFrame.getMenu().initReceptionist(this, user.name() + " " + user.surname());
            case "Patient" -> dashboardFrame.getMenu().initPatient(this, user.name() + " " + user.surname());
            default -> throw new RuntimeException("Authority error");
        }
    }

    public void menuSelected(String menuName) {
        service.menuSelected(menuName);
    }
}
