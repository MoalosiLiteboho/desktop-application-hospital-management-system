package com.geniescode.backend.signUp;

import java.time.LocalDate;

public record SignUp(
        String name,
        String surname,
        String gender,
        LocalDate dateOfBirth,
        String email
) {
}
