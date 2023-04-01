package com.geniescode.userProfile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserProfileController implements ActionListener {
    private final UserProfile userProfile;

    public UserProfileController(UserProfile userProfile) {
        this.userProfile = userProfile;
        this.userProfile.addButtonListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource().equals(userProfile.getRestoreButton()))
            userProfile.restoreFields();
        if(event.getSource().equals(userProfile.getSavaChangesButton()))
            saveChanges();
    }

    private void saveChanges() {

    }
}
