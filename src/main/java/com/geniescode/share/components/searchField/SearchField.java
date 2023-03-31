package com.geniescode.share.components.searchField;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

public class SearchField extends JTextField {
    private final Integer cornerCurve;
    private final String hintText;
    private final Color borderColor;
    public SearchField(Integer cornerCurve, String hintText, Color borderColor) {
        this.cornerCurve = cornerCurve;
        this.hintText = hintText;
        this.borderColor = borderColor;
        initComponents();
    }

    private void initComponents() {
        setOpaque(false);
        setBorder(new EmptyBorder(10, 10, 10, 50));
        setFont(new Font("sanserif", Font.PLAIN, 14));
    }

    private void addHint(Graphics graphics) {
        int c1 = getForeground().getRGB();
        int m = 0xfefefefe;
        int c0 = getBackground().getRGB();
        Insets insets = getInsets();
        int c2 = ((c0 & m) >>> 1) + ((c1 & m) >>> 1);
        FontMetrics fontMetrics = graphics.getFontMetrics();

        if (getText().length() == 0) {
            graphics.setColor(new Color(c2, true));
            graphics.drawString(hintText, insets.left, getHeight() / 2 + fontMetrics.getAscent() / 2 - 2);
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics.create();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.setColor(borderColor);
        graphics2D.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerCurve, cornerCurve));
        graphics2D.setColor(Color.white);
        graphics2D.fill(new RoundRectangle2D.Double(2, 2, getWidth() - 4, getHeight() - 4 , cornerCurve, cornerCurve));
        addHint(graphics);
        super.paintComponent(graphics);
    }
}
