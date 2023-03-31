package com.geniescode.user;

import java.time.LocalDate;

public record User(
        int Id,
        String name,
        String surname,
        String gender,
        LocalDate dateOfBirth,
        String email,
        Integer authority
) {
}
