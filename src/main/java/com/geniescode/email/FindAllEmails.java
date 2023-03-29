package com.geniescode.email;

import com.geniescode.dao.DAOImplementation;
import com.geniescode.user.UserDetails;

import java.util.List;
import java.util.function.Supplier;

public class FindAllEmails implements Supplier<List<String>> {
    @Override
    public List<String> get() {
        DAOImplementation daoImplementation = new DAOImplementation();
        return daoImplementation.findAllUsers().stream()
                .map(UserDetails::email)
                .toList();
    }
}
