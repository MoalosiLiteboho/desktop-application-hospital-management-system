package com.geniescode.dashboard;

public class DashboardService {
    public void menuSelected(int index) {
        switch (index) {
            case 0 -> System.out.println("Menu item 0 selected");
            case 1 -> System.out.println("Menu item 1 selected");
            case 2 -> System.out.println("Menu item 2 selected");
            case 3 -> System.out.println("Menu item 3 selected");
            case 4 -> System.out.println("Menu item 4 selected");
            case 5 -> System.out.println("Menu item 5 selected");
            case 6 -> System.out.println("Menu item 6 selected");
            case 7 -> System.out.println("Menu item 7 selected");
            case 8 -> System.out.println("Menu item 8 selected");
            default -> System.out.println("Logout selected");
        }
    }
}
