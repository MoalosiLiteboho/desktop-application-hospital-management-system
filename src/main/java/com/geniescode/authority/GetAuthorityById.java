package com.geniescode.authority;

import com.geniescode.dao.DAOImplementation;

import java.util.List;
import java.util.function.Function;

public class GetAuthorityById implements Function<Integer, String> {
    @Override
    public String apply(Integer id) {
        List<Authority> authorityList = new DAOImplementation().findAllAuthorities();

        return authorityList.stream()
                .filter(authority -> authority.id().equals(id))
                .findFirst()
                .map(Authority::role)
                .orElseThrow(() -> new RuntimeException("Role of " + id + " Id is not found!"));
    }
}
