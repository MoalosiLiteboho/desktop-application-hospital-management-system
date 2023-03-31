package com.geniescode.backend.signIn;

import com.geniescode.backend.dashboard.DashboardFrame;
import com.geniescode.displayMessage.DisplayMessage;

import java.util.function.Consumer;

import static com.geniescode.backend.signIn.SignInValidator.isPasswordValid;
import static com.geniescode.backend.signIn.SignInValidator.isUsernameValid;


public class SignInService {
    private final SignIn credentials;

    public SignInService(SignIn signIn) {
        this.credentials = signIn;
        logInProcess();
    }

    public void logInProcess() {
        String result = isUsernameValid
                .and(isPasswordValid)
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
