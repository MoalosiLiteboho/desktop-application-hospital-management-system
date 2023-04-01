package com.geniescode.signIn;

import com.geniescode.dao.DAOImplementation;
import com.geniescode.user.UserDetails;

import java.util.function.Function;

public class GetIdByLogInCredentials implements Function<SignIn, Integer> {
    @Override
    public Integer apply(SignIn credentials) {
        UserDetails user = new DAOImplementation().findAllUsers()
                .stream()
                .filter(userDetails -> userDetails.email().equals(credentials.email()) && userDetails.password().equals(credentials.password()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Email and Password you entered are INVALID! \n Please try again using CORRECT credentials!"));

        if (user.enabled())
            throw new RuntimeException("This account is locked. \nPlease contact the administration to unlock this account");

        return user.id();
    }
}
