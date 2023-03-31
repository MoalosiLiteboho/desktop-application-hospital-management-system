package com.geniescode.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInsertController implements ActionListener {
    private final UserInsertPanel addUserPanel;

    public UserInsertController(UserInsertPanel addUserPanel) {
        this.addUserPanel = addUserPanel;
        addUserPanel.addButtonListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == addUserPanel.getReset())
            resetAction();
        if (event.getSource() == addUserPanel.getRegistration())
            registrationAction();
    }

    private void resetAction() {
        addUserPanel.clearFields();
    }

    private void registrationAction() {

    }
}
