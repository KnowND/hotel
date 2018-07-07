package DAO.impl;

import DAO.GuestDAO;
import DTO.Guest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by edik2 on 15.05.2018.
 */
public class GuestDAOImpl implements GuestDAO {

    private DataSource dataSource;

    public GuestDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int addGuest(Guest guest) {

        int add = 0;
        String sql = "INSERT INTO guest(first_name, surname, phone, passport) VALUES (?,?,?,?)";


        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

//            String name = booking.getPhoneGuest();
            preparedStatement.setString(1, guest.getName());
            preparedStatement.setString(2, guest.getSurname());
            preparedStatement.setString(3, guest.getPhone());
            preparedStatement.setString(4, guest.getPassport());

            add = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
//            logger.error("Error adding record to Account table ", e);

        }
        return add;
    }

    @Override
    public Guest getGuestById(int id) {
        String sql = "SELECT first_name, surname, phone, passport FROM guest WHERE id = ?";
        Guest guest = null;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                String name = resultSet.getString("first_name");
                String surname = resultSet.getString("surname");
                String phone = resultSet.getString("phone");
                String passport = resultSet.getString("passport");

                guest = new Guest(name, surname, phone, passport);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return guest;

    }
}
