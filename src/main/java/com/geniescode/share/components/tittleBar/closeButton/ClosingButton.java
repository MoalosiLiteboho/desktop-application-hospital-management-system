package com.geniescode.share.components.tittleBar.closeButton;

import com.geniescode.share.components.tittleBar.Button;
import net.miginfocom.swing.MigLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Color;

public class ClosingButton extends JComponent {
    public ClosingButton() {
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        Button closingButton = new Button();

        closingButton.setBackground(Color.red);
        closingButton.addActionListener(action -> System.exit(0));

        panel.setLayout(new MigLayout("inset 3px"));
        panel.add(closingButton);
        panel.setOpaque(false);

        setLayout(new MigLayout("inset 3px, fill", "[fill]", "[fill]"));
        add(panel);
    }
}
