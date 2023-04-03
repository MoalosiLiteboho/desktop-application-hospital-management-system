package com.geniescode.user;

import java.util.function.Function;

public class GetUserById implements Function<Integer, User> {
    @Override
    public User apply(Integer userId) {
        return new FindAllUsers().get()
                .stream()
                .filter(user -> user.id() == userId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User with " + userId + " id not found."));
    }
}
