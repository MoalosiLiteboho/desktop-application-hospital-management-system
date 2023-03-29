package com.geniescode.user;

import java.time.LocalDate;

public record UserDetails(
        int Id,
        String name,
        String surname,
        String gender,
        LocalDate dateOfBirth,
        String email,
        Integer authority,
        LocalDate expiryDate,
        boolean enabled,
        String password
) {
    public boolean isEnabled() {
        return enabled;
    }
}
