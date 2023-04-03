package com.geniescode.tables;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ActionButton extends JButton {
    public ActionButton() {
        initComponents();
    }

    private void initComponents() {
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(3, 3, 3, 3));
    }
}
