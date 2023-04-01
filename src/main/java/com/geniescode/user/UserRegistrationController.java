package com.geniescode.user;

import com.geniescode.share.id.UserIdGenerator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserRegistrationController implements ActionListener {
    private final UserRegistrationPanel registrationPanel;

    public UserRegistrationController(UserRegistrationPanel registrationPanel) {
        this.registrationPanel = registrationPanel;
        registrationPanel.addButtonListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == registrationPanel.getReset())
            resetAction();
        if (event.getSource() == registrationPanel.getRegistration())
            registrationAction();
    }

    private void resetAction() {
        registrationPanel.clearFields();
    }

    private void registrationAction() {
        UserRegistrationPanelService registrationService = new UserRegistrationPanelService(
                new User(
                        new UserIdGenerator().get(),
                        registrationPanel.getName(),
                        registrationPanel.getSurname(),
                        registrationPanel.getGender(),
                        registrationPanel.getDateOfBirth(),
                        registrationPanel.getEmail(),
                        registrationPanel.getAuthority()
                ),
                "all user registration");
        registrationService.setRegistrationPanel(registrationPanel);
        registrationService.registrationProcess();
    }
}
