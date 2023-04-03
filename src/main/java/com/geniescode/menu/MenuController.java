package com.geniescode.menu;

import org.jdesktop.animation.timing.Animator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {
    private final Animator animator;
    private MenuButton selectedMenu;
    private MenuButton unSelectedMenu;
    private MenuEvent event;

    public MenuController(Animator animator) {
        this.animator = animator;
    }

    public void setMenuEvent(MenuEvent event) {
        this.event = event;
    }

    public void setSelectedMenu(MenuButton selectedMenu) {
        this.selectedMenu = selectedMenu;
    }

    public void setUnselectedMenu(MenuButton unSelectedMenu) {
        this.unSelectedMenu = unSelectedMenu;
    }

    public void actionPerformed(ActionEvent event) {
        MenuButton menu = (MenuButton) event.getSource();
        if (!animator.isRunning()) {
            if (menu != selectedMenu) {
                unSelectedMenu = selectedMenu;
                selectedMenu = menu;
                animator.start();
                this.event.menuSelected(menu.getText());
            }
        }
    }
}
