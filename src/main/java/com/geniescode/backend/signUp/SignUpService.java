package com.geniescode.backend.signUp;

import com.geniescode.dao.DAOImplementation;
import com.geniescode.displayMessage.DisplayMessage;

import java.util.function.Consumer;

import static com.geniescode.backend.signUp.SignUpValidator.*;

public class SignUpService {
    private final SignUpFrame registration;
    private final SignUp signUp;
    private final DisplayMessage displayMessage;

    public SignUpService(SignUpFrame registration, SignUp signUp) {
        this.registration = registration;
        this.signUp = signUp;
        displayMessage = new DisplayMessage();
        registrationProcess();
    }


    private void registrationProcess() {
        String results = isNameValid
                .and(isSurnameValid)
                .and(isDateOfBirthValid)
                .and(isGenderValid)
                .and(isEmailValid)
                .apply(signUp);

        registerUserIfAllFieldAreFilled(results, displayMessage);
    }

    private void registerUserIfAllFieldAreFilled(String result, Consumer<String> showUserError) {
        if(!"SUCCESS".equals(result)) showUserError.accept(result);
        else registration();
    }

    private void registration() {
        new DAOImplementation().saveUser(new SignUpDTOMapper().apply(signUp));
        displayMessage.accept(signUp.name() + " " + signUp.surname() + " has registered successfully \nPassword is: " + signUp.name() + "@12345");
        registration.clearFields();
    }
}