package com.geniescode.authority;

import com.geniescode.dao.DAOImplementation;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class GetAuthorityList implements Supplier<List<String>> {
    @Override
    public List<String> get() {
        List<Authority> allAuthorities = new DAOImplementation().findAllAuthorities();

        return allAuthorities.stream()
                .map(Authority::role)
                .collect(Collectors.toList());
    }
}
