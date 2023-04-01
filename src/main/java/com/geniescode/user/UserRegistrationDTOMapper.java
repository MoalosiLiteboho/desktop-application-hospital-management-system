package com.geniescode.user;

import com.geniescode.authority.GetAuthorityIdByRole;
import com.geniescode.date.ExpiryDateGenerator;
import com.geniescode.password.PasswordGenerator;

import java.util.function.Function;

public class UserRegistrationDTOMapper implements Function<User, UserDetails> {
    @Override
    public UserDetails apply(User user) {
        return new UserDetails(
                user.Id(),
                user.name(),
                user.surname(),
                user.gender(),
                user.dateOfBirth(),
                user.email(),
                new GetAuthorityIdByRole().apply(user.authority()),
                new ExpiryDateGenerator().get(),
                true,
                new PasswordGenerator().apply(user.name())
        );
    }
}
