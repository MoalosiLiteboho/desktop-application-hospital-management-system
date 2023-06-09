package com.geniescode.dao;

import com.geniescode.appointment.Appointment;
import com.geniescode.authority.Authority;
import com.geniescode.database.DatabaseConnection;
import com.geniescode.password.PasswordEncryptor;
import com.geniescode.user.User;
import com.geniescode.user.UserDetails;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DAOImplementation implements DAO{

    @Override
    public void saveUser(UserDetails user) {
        try {
            PreparedStatement statement = new DatabaseConnection().get().prepareStatement("insert into HospitalSystemDesktopApplication.User(Id, Name, Surname, Gender, DateOfBirth) values (?, ?, ?, ?, ?)");
            statement.setInt(1, user.id());
            statement.setString(2, user.name());
            statement.setString(3, user.surname());
            statement.setString(4, user.gender());
            statement.setDate(5, Date.valueOf(user.dateOfBirth()));

            statement.executeUpdate();
            statement = new DatabaseConnection().get().prepareStatement("insert into HospitalSystemDesktopApplication.UserAccount(UserId, AuthorityId, Email, Password, Enabled, ExpiryDate) values (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, user.id());
            statement.setInt(2, user.authority());
            statement.setString(3, user.email());
            statement.setString(4, new PasswordEncryptor().apply(user.password()));
            statement.setBoolean(5, user.enabled());
            statement.setDate(6, Date.valueOf(user.expiryDate()));

            statement.executeUpdate();
        } catch(SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<Authority> findAllAuthorities() {
        List<Authority> authorityList = new ArrayList<>();
        try {
            PreparedStatement statement = new DatabaseConnection().get().prepareStatement("select * from Authorities");
            ResultSet result = statement.executeQuery();

            while (result.next())
                authorityList.add(new Authority(
                        result.getInt("Id"),
                        result.getString("Role")
                ));
            return authorityList;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public List<UserDetails> findAllUsers() {
        List<UserDetails> userDetailsList = new ArrayList<>();
        try {
            PreparedStatement statement = new DatabaseConnection().get().prepareStatement("select Id, Name ,Surname ,Gender ,DateOfBirth ,AuthorityId ,Email ,Password, Enabled ,ExpiryDate from " +
                    "(select * from HospitalSystemDesktopApplication.User user inner join HospitalSystemDesktopApplication.UserAccount account on user.Id = account.UserId) " +
                    "as UserTable");

            ResultSet result = statement.executeQuery();

            while (result.next())
                userDetailsList.add(
                        new UserDetails(
                                result.getInt("Id"),
                                result.getString("Name"),
                                result.getString("Surname"),
                                result.getString("Gender"),
                                LocalDate.parse(result.getString("DateOfBirth")),
                                result.getString("Email"),
                                result.getInt("AuthorityId"),
                                result.getDate("ExpiryDate").toLocalDate(),
                                result.getBoolean("Enabled"),
                                result.getString("Password")
                        ));
            return userDetailsList;

        } catch(SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUserById(int userId) {
        try {
            PreparedStatement statement = new DatabaseConnection().get().prepareStatement("delete from UserAccount where UserId = ?");
            statement.setInt(1, userId);

            statement.executeUpdate();

            statement = new DatabaseConnection().get().prepareStatement("delete from User where Id = ?");
            statement.setInt(1, userId);

            statement.executeUpdate();
        }catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void bookAppointment(Appointment appointment) {

    }

    @Override
    public void updateAppointment(Appointment appointment) {

    }

    @Override
    public void deleteAppointmentById(int appointmentId) {

    }

    @Override
    public List<Appointment> findAllAppointment() {
        return null;
    }
}
