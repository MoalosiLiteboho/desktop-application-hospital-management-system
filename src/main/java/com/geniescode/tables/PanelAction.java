package com.geniescode.tables;

import com.geniescode.share.components.panel.Panel;
import net.miginfocom.swing.MigLayout;

public class PanelAction extends Panel {
    public PanelAction() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new MigLayout("inset 2px, gap 0"));
    }
}
