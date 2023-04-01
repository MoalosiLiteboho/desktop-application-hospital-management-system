package com.geniescode.signIn;

import com.geniescode.dashboard.DashboardFrame;
import com.geniescode.displayMessage.DisplayMessage;

import java.util.function.Consumer;


public class SignInService {
    private final SignIn credentials;

    public SignInService(SignIn signIn) {
        this.credentials = signIn;
        logInProcess();
    }

    public void logInProcess() {
        String result = SignInValidator.isUsernameValid
                .and(SignInValidator.isPasswordValid)
                .apply(credentials);

        tryToLogInIfAllFieldAreFilled(result, new DisplayMessage());
    }

    private void tryToLogInIfAllFieldAreFilled(String result, Consumer<String> showUserError) {
        if(!"SUCCESS".equals(result)) showUserError.accept(result);
        else logIn();
    }

    private void logIn() {
        Integer userId = new GetIdByLogInCredentials().apply(credentials);
        new DashboardFrame().setVisible(true);
    }
}
