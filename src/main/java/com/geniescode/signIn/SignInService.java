package com.geniescode.signIn;

import com.geniescode.Main;
import com.geniescode.dashboard.DashboardFrame;
import com.geniescode.displayMessage.DisplayMessage;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;


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
        showDashboardFrame(userId);
    }

    public static void showDashboardFrame(int userId) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException exception) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, exception);
        }
        EventQueue.invokeLater(() -> new DashboardFrame(userId).setVisible(true));
    }
}
