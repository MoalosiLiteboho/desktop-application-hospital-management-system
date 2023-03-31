package com.geniescode.share.components.tittleBar;

import net.miginfocom.swing.MigLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.function.BiConsumer;

public class TittleBarPanel extends JPanel {
    private Button close;
    private Button minimize;
    private Button resize;
    private final JFrame frame;

    public TittleBarPanel(JFrame frame) {
        this.frame = frame;
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        close = new Button();
        minimize = new Button();
        resize = new Button();

        resize.setBackground(Color.green);

        minimize.setBackground(Color.orange);

        close.setBackground(Color.red);

        panel.setLayout(new MigLayout("inset 3"));
        panel.add(close);
        panel.add(minimize);
        panel.add(resize);
        panel.setOpaque(false);

        setLayout(new MigLayout("inset 3, fill", "[fill]", "[fill]"));
        add(panel);
        setOpaque(false);
        addController.accept(frame, this);
    }

    private final BiConsumer<JFrame, TittleBarPanel> addController = TittleBarController::new;

    public void addActionListener (TittleBarController controller) {
        close.addActionListener(controller);
        resize.addActionListener(controller);
        minimize.addActionListener(controller);
    }

    public Button getClose() {
        return close;
    }

    public Button getMinimize() {
        return minimize;
    }

    public Button getResize() {
        return resize;
    }
}