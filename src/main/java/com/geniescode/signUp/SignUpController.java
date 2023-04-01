package com.geniescode.signUp;

import com.geniescode.share.id.UserIdGenerator;
import com.geniescode.user.User;
import com.geniescode.user.UserRegistrationPanelService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpController implements ActionListener {
    private final SignUpFrame registration;

    public SignUpController(SignUpFrame registration) {
        this.registration = registration;
        registration.addButtonListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == registration.getRegistration())
            registrationAction();
        if(event.getSource() == registration.getLogIn())
            logInAction();
    }

    private void registrationAction() {
        UserRegistrationPanelService registrationService = new UserRegistrationPanelService(
                new User(
                        new UserIdGenerator().get(),
                        registration.getName(),
                        registration.getSurname(),
                        registration.getGender(),
                        registration.getDateOfBirth(),
                        registration.getEmail(),
                        "Patient"
                ),
                "signUp");
        registrationService.setSignUp(registration);
        registrationService.registrationProcess();
    }

    private void logInAction() {
        new SignUpFrame().setVisible(true);
        registration.dispose();
    }
}
