package com.geniescode.dashboard;

public class DashboardService {
    public void menuSelected(String menuName) {
        switch (menuName) {
            case "Dashboard" -> System.out.println(menuName);
            case "LogOut" -> System.exit(0);
            default -> throw new RuntimeException("Menu error");
        }
    }
}
