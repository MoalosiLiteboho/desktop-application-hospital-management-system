package com.geniescode.authority;

import com.geniescode.dao.DAOImplementation;

import java.util.List;
import java.util.function.Function;

public class GetAuthorityIdByRole implements Function<String, Integer> {
    @Override
    public Integer apply(String role) {
        return new DAOImplementation().findAllAuthorities()
                .stream()
                .filter(authority -> role.equals(authority.role()))
                .mapToInt(Authority::id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Id of " + role + " is not found!"));
    }
}
