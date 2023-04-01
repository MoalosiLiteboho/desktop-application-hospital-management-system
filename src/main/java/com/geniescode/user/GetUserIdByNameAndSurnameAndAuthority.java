package com.geniescode.user;

import com.geniescode.authority.GetAuthorityIdByRole;
import com.geniescode.dao.DAOImplementation;

import java.util.function.BiFunction;

public class GetUserIdByNameAndSurnameAndAuthority implements BiFunction<String, String, Integer> {
    @Override
    public Integer apply(String authority, String names) {
        int authorityId = new GetAuthorityIdByRole().apply(authority);
        String[] arrayNames = names.split(" ");
        return new DAOImplementation().findAllUsers()
                .stream()
                .filter(user -> user.authority().equals(authorityId) && user.name().equals(arrayNames[1]) && user.surname().equals(arrayNames[2]))
                .findFirst()
                .map(UserDetails::id)
                .orElseThrow(() -> new RuntimeException(authority + " with names of " + names + " not found."));
    }
}
