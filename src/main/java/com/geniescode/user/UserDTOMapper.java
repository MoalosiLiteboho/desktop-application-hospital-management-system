package com.geniescode.user;

import com.geniescode.authority.GetAuthorityById;

import java.util.function.Function;

public class UserDTOMapper implements Function<UserDetails, User> {
    @Override
    public User apply(UserDetails user) {
        return new User(
                user.id(),
                user.name(),
                user.surname(),
                user.gender(),
                user.dateOfBirth(),
                user.email(),
                new GetAuthorityById().apply(user.authority())
        );
    }
}
