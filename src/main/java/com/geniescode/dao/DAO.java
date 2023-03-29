package com.geniescode.dao;

import com.geniescode.authority.Authority;
import com.geniescode.user.UserDTO;
import com.geniescode.user.UserDetails;

import java.util.List;

public interface DAO {
    void saveUser(UserDetails user);
    List<Authority> findAllAuthorities();
    List<UserDetails> findAllUsers();
    void updateUser(UserDTO user);
    void deleteUserById(int userId);
}
