package com.geniescode.menu;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class MenuButton extends JButton {
    private float animate;
    public void setAnimate(float animate) {
        this.animate = animate;
        repaint(); 
    }

    public MenuButton () {
        setContentAreaFilled(false);
        setForeground(Color.gray);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setHorizontalAlignment(SwingConstants.LEFT);
        setBackground(new Color(37,241,16));
        setBorder(new EmptyBorder(8, 20, 8, 15));
    }

    @Override
    public void paint(Graphics graphics) {
        double width = getWidth(), height = getHeight();
        Graphics2D graphics2D = (Graphics2D) graphics.create();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        double x = (animate * width) - width;
        Area area = new Area(new RoundRectangle2D.Double(x, 0, width, height, height, height));
        area.add(new Area(new Rectangle2D.Double(x, 0, height, height)));
        graphics2D.setColor(getBackground());
        graphics2D.fill(area);
        graphics2D.dispose();
        super.paint(graphics);
    }
}
