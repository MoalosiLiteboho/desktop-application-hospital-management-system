package com.geniescode.user;

import com.geniescode.authority.GetAuthorityIdByRole;
import com.geniescode.dao.DAOImplementation;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GetUserListByAuthority implements Function<String, List<String>> {
    @Override
    public List<String> apply(String authority) {
        int authorityId = new GetAuthorityIdByRole().apply(authority);

        return new DAOImplementation().findAllUsers()
                .stream()
                .filter(user -> user.authority().equals(authorityId))
                .map(user -> user.name() + " " + user.surname())
                .collect(Collectors.toList());
    }
}
