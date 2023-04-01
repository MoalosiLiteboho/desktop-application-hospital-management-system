package com.geniescode.userProfile;

import com.geniescode.user.User;
import com.geniescode.user.UserRegistrationPanelService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserProfileController implements ActionListener {
    private final UserProfile userProfilePanel;

    public UserProfileController(UserProfile userProfilePanel) {
        this.userProfilePanel = userProfilePanel;
        this.userProfilePanel.addButtonListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource().equals(userProfilePanel.getRestoreButton()))
            userProfilePanel.restoreFields();
        if(event.getSource().equals(userProfilePanel.getSavaChangesButton()))
            saveChanges();
    }

    private void saveChanges() {
        UserRegistrationPanelService service = new UserRegistrationPanelService(
                new User(
                        userProfilePanel.getUserId(),
                        userProfilePanel.getName(),
                        userProfilePanel.getSurname(),
                        userProfilePanel.getGender(),
                        userProfilePanel.getDateOfBirth(),
                        userProfilePanel.getEmail(),
                        userProfilePanel.getAuthority()
                ),
                "userProfile"
        );
        service.setUserProfile(userProfilePanel);
        service.updateUserProcess();
    }
}
