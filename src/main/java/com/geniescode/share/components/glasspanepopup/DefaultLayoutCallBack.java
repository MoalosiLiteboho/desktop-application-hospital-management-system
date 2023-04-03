package com.geniescode.share.components.glasspanepopup;

import java.awt.Component;
import java.awt.Dimension;
import net.miginfocom.layout.BoundSize;
import net.miginfocom.layout.ComponentWrapper;
import net.miginfocom.layout.LayoutCallback;
import net.miginfocom.layout.UnitValue;

public class DefaultLayoutCallBack extends LayoutCallback {

    public Component getParent() {
        return parent;
    }

    private final Component parent;

    public DefaultLayoutCallBack(Component parent) {
        this.parent = parent;
    }

    @Override
    public BoundSize[] getSize(ComponentWrapper componentWrapper) {
        Dimension parentSize = parent.getSize();
        Dimension preferredSize = ((Component) componentWrapper.getComponent()).getPreferredSize();
        int margin = 50;
        int width = preferredSize.width;
        int height = preferredSize.height;
        if (preferredSize.getWidth() > parentSize.getWidth() - margin)
            width = Math.max(parentSize.width - margin, componentWrapper.getMinimumWidth(0));
        if (preferredSize.getHeight() > parentSize.getHeight() - margin)
            height = Math.max(parentSize.height - margin, componentWrapper.getMinimumHeight(0));

        return new BoundSize[]{new BoundSize(new UnitValue(width), ""), new BoundSize(new UnitValue(height), "")};
    }
}
