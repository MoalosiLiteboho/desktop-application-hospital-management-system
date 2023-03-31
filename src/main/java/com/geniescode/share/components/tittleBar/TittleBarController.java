package com.geniescode.share.components.tittleBar;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TittleBarController implements ActionListener {
    private final JFrame frame;
    private final TittleBarPanel tittleBarPanel;
    private final ComponentResizer resizer;
    private boolean register = true;
    private int x, y;

    public TittleBarController(JFrame frame, TittleBarPanel tittleBarPanel) {
        this.frame = frame;
        this.tittleBarPanel = tittleBarPanel;
        this.resizer = new ComponentResizer();
        this.tittleBarPanel.addActionListener(this);
        initFrameResizer(frame);
    }

    private void initFrameResizer(JFrame frame) {
        this.resizer.setSnapSize(new Dimension(10, 10));
        this.resizer.setMinimumSize(new Dimension(800, 500));
        this.resizer.registerComponent(this.frame);

        this.frame.addWindowStateListener(event -> {
            if (event.getNewState() == JFrame.MAXIMIZED_BOTH) {
                this.resizer.deregisterComponent(this.frame);
                this.register = false;
            } else if (event.getNewState() == JFrame.NORMAL) {
                if (!this.register) {
                    this.resizer.registerComponent(this.frame);
                    this.register = true;
                }
            }
        });

        this.tittleBarPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                if (frame.getExtendedState() == JFrame.NORMAL && java.awt.event.MouseEvent.BUTTON1 == e.getButton()) {
                    x = e.getX() + 3;
                    y = e.getY() + 3;
                }
            }
        });

        this.tittleBarPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent e) {
                if (java.awt.event.MouseEvent.BUTTON1 == e.getButton())
                    if (frame.getExtendedState() == JFrame.NORMAL)
                        frame.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
            }
        });
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == tittleBarPanel.getClose())
            closeAction();
        if(event.getSource() == tittleBarPanel.getMinimize())
            minimizeAction();
        if(event.getSource() == tittleBarPanel.getResize())
            resizeAction();
    }

    private void closeAction() {
        System.exit(0);
    }

    private void minimizeAction() {
        frame.setState(JFrame.ICONIFIED);
    }

    private void resizeAction() {
        if (frame.getExtendedState() == JFrame.MAXIMIZED_BOTH)
            frame.setExtendedState(JFrame.NORMAL);
        else
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

}
