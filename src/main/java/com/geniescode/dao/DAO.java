package com.geniescode.dao;

import com.geniescode.user.UserDTO;
import com.geniescode.user.UserDetails;

import java.util.List;

public interface DAO {
    void saveUser(UserDetails user);
    List<UserDetails> findAllUsers();
    void updateUser(UserDTO user);
    void deleteUserById(int userId);
}
