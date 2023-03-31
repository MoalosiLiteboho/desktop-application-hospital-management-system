package com.geniescode.dao;

import com.geniescode.appointment.Appointment;
import com.geniescode.authority.Authority;
import com.geniescode.user.User;
import com.geniescode.user.UserDetails;

import java.util.List;

public interface DAO {
    void saveUser(UserDetails user);
    List<Authority> findAllAuthorities();
    List<UserDetails> findAllUsers();
    void updateUser(User user);
    void deleteUserById(int userId);
    void bookAppointment(Appointment appointment);
    void updateAppointment(Appointment appointment);
    void deleteAppointmentById(int appointmentId);
    List<Appointment> findAllAppointment();
}
