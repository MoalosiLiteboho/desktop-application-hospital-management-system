package com.geniescode.dashboard;

import com.geniescode.menu.Menu;
import com.geniescode.share.components.glasspanepopup.GlassPanePopup;
import com.geniescode.share.components.panel.Panel;
import com.geniescode.share.components.tittleBar.TittleBarPanel;
import com.geniescode.forms.UsersList;
import net.miginfocom.swing.MigLayout;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class DashboardFrame extends JFrame {
    private Menu menu;
    private Panel rightSide;
    private final int userId;

    public DashboardFrame(int userId) {
        this.userId = userId;
        initComponents();
        GlassPanePopup.install(this);
        new DashboardController(this, this.userId);
    }

    private void initComponents() {
        Panel background = new Panel();
        Panel leftSide = new Panel();
        rightSide = new Panel();
        Panel menuPanel = new Panel();
        menu = new Menu();

        menuPanel.setLayout(new BorderLayout());
        menuPanel.add(menu);
        menuPanel.setBackground(Color.gray);

        rightSide.setLayout(new BorderLayout());
        rightSide.add(new UsersList());
        rightSide.setBackground(Color.white);

        leftSide.setLayout(new MigLayout("inset 0, gap 0, wrap"));
        leftSide.add(new TittleBarPanel(this), "width 100%, height 70px");
        leftSide.add(menuPanel, "width 100%, height 100%");
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

    public Menu getMenu(){
        return menu;
    }

    public Panel getRightSide() {
        return rightSide;
    }

    public int getUserId() {
        return userId;
    }
}
