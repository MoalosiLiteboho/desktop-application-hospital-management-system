package com.geniescode.user;

import com.geniescode.dao.DAOImplementation;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FindAllUsers implements Supplier<List<User>> {
    @Override
    public List<User> get() {
        return new DAOImplementation().findAllUsers()
                .stream()
                .map(user -> new UserDTOMapper().apply(user))
                .collect(Collectors.toList());
    }
}
