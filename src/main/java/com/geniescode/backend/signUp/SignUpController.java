package com.geniescode.backend.signUp;

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
        new SignUpService(
                registration,
                new SignUp(
                        registration.getName(),
                        registration.getSurname(),
                        registration.getGender(),
                        registration.getDateOfBirth(),
                        registration.getEmail()
                )
        );
    }

    private void logInAction() {
        new SignUpFrame().setVisible(true);
        registration.dispose();
    }
}
