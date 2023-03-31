package com.geniescode.user;

import com.geniescode.dao.DAOImplementation;

import java.util.function.Predicate;

public class UserExistsById implements Predicate<Integer> {
    @Override
    public boolean test(Integer userId) {
        return new DAOImplementation().findAllUsers()
                .stream()
                .anyMatch(userDetails -> userDetails.id() == userId);
    }
}
