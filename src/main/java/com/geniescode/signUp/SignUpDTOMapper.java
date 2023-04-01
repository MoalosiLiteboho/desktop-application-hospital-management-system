package com.geniescode.signUp;

import com.geniescode.authority.GetAuthorityIdByRole;
import com.geniescode.date.ExpiryDateGenerator;
import com.geniescode.share.id.UserIdGenerator;
import com.geniescode.user.UserDetails;

import java.util.function.Function;

public class SignUpDTOMapper implements Function<SignUp, UserDetails> {
    @Override
    public UserDetails apply(SignUp signUp) {
        return new UserDetails(
                new UserIdGenerator().get(),
                signUp.name(),
                signUp.surname(),
                signUp.gender(),
                signUp.dateOfBirth(),
                signUp.email(),
                new GetAuthorityIdByRole().apply("Patient"),
                new ExpiryDateGenerator().get(),
                true,
                signUp.name() + "@12345"
        );
    }
}
