package com.geniescode.user;

import com.geniescode.dao.DAOImplementation;
import com.geniescode.displayMessage.DisplayMessage;
import com.geniescode.signUp.SignUpFrame;
import com.geniescode.userProfile.UserProfile;

import java.util.function.Consumer;

import static com.geniescode.user.UserRegistrationValidator.*;

public class UserRegistrationPanelService {
    private final User user;
    private final DisplayMessage displayMessage;
    private UserRegistrationPanel registrationPanel;
    private SignUpFrame registration;
    private final String whichPanel;
    private UserProfile userProfile;


    public UserRegistrationPanelService(User user, String whichPanel) {
        this.user = user;
        this.whichPanel = whichPanel;
        displayMessage =  new DisplayMessage();
    }

    public void registrationProcess() {
        String results = isAuthorityValid
                .and(isNameValid)
                .and(isSurnameValid)
                .and(isGenderValid)
                .and(isDateOfBirthValid)
                .and(isEmailValid)
                .apply(user);
        registerUserIfAllFieldAreFilled(results, displayMessage);
    }

    private void registerUserIfAllFieldAreFilled(String result, Consumer<String> showUserError) {
        if(!"SUCCESS".equals(result)) showUserError.accept(result);
        else registration();
    }

    private void registration() {
        new DAOImplementation().saveUser(new UserRegistrationDTOMapper().apply(user));
        displayMessage.accept(user.name() + " " + user.surname() + " has registered successfully \nPassword is: " + user.name() + "@12345");
        if(whichPanel.equals("signUp"))
            registration.clearFields();
        else
            registrationPanel.clearFields();
    }

    public void updateUserProcess() {
        String results = isNameValid
                .and(isSurnameValid)
                .and(isGenderValid)
                .and(isDateOfBirthValid)
                .and(isEmailValid)
                .apply(user);
        updateUserIfAllFieldAreFilled(results, displayMessage);
    }

    private void updateUserIfAllFieldAreFilled(String result, Consumer<String> showUserError) {
        if(!"SUCCESS".equals(result)) showUserError.accept(result);
        else updateUser();
    }

    private void updateUser() {
        new DAOImplementation().updateUser(user);
        displayMessage.accept(user.id() +  " updated successfully");
        if (whichPanel.equals("userProfile"))
            userProfile.restoreFields();
    }

    public void setRegistrationPanel(UserRegistrationPanel registrationPanel) {
        this.registrationPanel = registrationPanel;
    }

    public void setSignUp(SignUpFrame registration) {
        this.registration = registration;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
