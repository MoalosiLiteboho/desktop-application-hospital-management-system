package com.geniescode.user;

import java.time.LocalDate;

public record User(
        int id,
        String name,
        String surname,
        String gender,
        LocalDate dateOfBirth,
        String email,
        String authority
) {
}
