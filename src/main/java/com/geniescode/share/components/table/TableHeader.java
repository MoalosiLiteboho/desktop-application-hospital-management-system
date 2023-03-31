package com.geniescode.share.components.table;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class TableHeader extends JLabel {
    public TableHeader(String text) {
        super(text);
        initComponents();
    }

    private void initComponents() {
        setOpaque(true);
        setBackground(Color.white);
        setFont(new Font("sanserif", Font.BOLD, 12));
        setForeground(Color.gray);
        setBorder(new EmptyBorder(10, 5, 10, 5));
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.lightGray);
        graphics.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
    }
}
