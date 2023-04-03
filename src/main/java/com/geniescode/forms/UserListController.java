package com.geniescode.forms;

import com.geniescode.share.components.glasspanepopup.GlassPanePopup;
import com.geniescode.addUser.PopUpPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserListController implements ActionListener {
    private final UsersList usersListPanel;

    public UserListController(UsersList usersListPanel) {
        this.usersListPanel = usersListPanel;
        usersListPanel.addUserListController(this);
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource().equals(usersListPanel.getAddUserButton()))
            showUserRegistrationPanel();
    }

    private void showUserRegistrationPanel() {
        GlassPanePopup.showPopup(new PopUpPanel());
    }
}
