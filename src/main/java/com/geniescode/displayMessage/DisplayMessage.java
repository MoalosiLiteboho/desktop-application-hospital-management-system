package com.geniescode.displayMessage;

import javax.swing.JOptionPane;
import java.util.function.Consumer;

public class DisplayMessage implements Consumer<String> {
    @Override
    public void accept(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
