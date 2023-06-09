package com.geniescode.email;

import java.util.function.Predicate;

public class EmailTaken implements Predicate<String> {
    @Override
    public boolean test(String email) {
        return new FindAllEmails().get()
                .stream()
                .anyMatch(email::equals);
    }
}