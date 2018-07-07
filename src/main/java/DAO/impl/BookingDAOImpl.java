package DAO.impl;

import DAO.BookingDAO;
import DTO.Booking;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by edik2 on 15.05.2018.
 */
public class BookingDAOImpl implements BookingDAO {


    private DataSource dataSource;

    public BookingDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int addBooking(Booking booking) {

        String sql = "INSERT INTO booking(employee, status, class_room, date_of_settlement, date_of_eviction, name_guest, surname_guest, phone_guest, booking_date) VALUES (?,?,?,?,?,?,?,?,?)";

        int add = 0;

        DateTime settlement = booking.getDateOfSettlement();
        DateTime eviction = booking.getDateOfEviction();
        DateTime now = getCurrentDateTime();


        if (settlement.getMillis() - now.getMillis() <= 0 || now.compareTo(eviction) > 0) return 0;

        if (eviction.compareTo(settlement) <= 0){
            return 0;
        }

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, booking.getEmployeeId());
            preparedStatement.setString(2, booking.getStatus());
            preparedStatement.setInt(3, booking.getRoomClass());
            preparedStatement.setDate(4, new Date(booking.getDateOfSettlement().getMillis()));
            preparedStatement.setDate(5, new Date(booking.getDateOfEviction().getMillis()));
            preparedStatement.setString(6, booking.getNameGuest());
            preparedStatement.setString(7, booking.getSurnameGuest());
            preparedStatement.setString(8, booking.getPhoneGuest());
            preparedStatement.setDate(9, new Date(booking.getBookingDate().getMillis()));


            add =  preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
//            logger.error("Error adding record to Account table ", e);

        }
        return add;
    }

    public Booking findBookingByGuestNameAndSurname(String name, String surname) {
        String sql = "SELECT id, phone_guest, status, class_room, date_of_settlement, date_of_eviction, employee FROM booking WHERE name_guest = ? AND surname_guest = ?";

        try (Connection connection = dataSource.getConnection()
             ) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
//            List<Booking> bookingList = new ArrayList<>();
            Booking booking = null;
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                int id = Integer.parseInt(resultSet.getString(1));
                String phoneGuest = resultSet.getString(2);
                String status = resultSet.getString(3);
                int roomClass = Integer.parseInt(resultSet.getString(4));
                DateTime dateSettlement = new DateTime(resultSet.getDate(5).getTime());
                DateTime dateEviction = new DateTime(resultSet.getDate(6).getTime());
                int employee = Integer.parseInt(resultSet.getString(7));

                booking = new Booking(id, employee, phoneGuest, status, name, surname, roomClass, dateSettlement, dateEviction);

//                bookingList.add(booking);
            }

            return booking;

//            return bookingList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Booking> getAllBooking(){

        String sql = "SELECT id, phone_guest, status, class_room, date_of_settlement, date_of_eviction, name_guest, surname_guest, booking_date FROM booking";
        List<Booking> bookingList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()
        ) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Booking booking = null;
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                int id = Integer.parseInt(resultSet.getString(1));
                String phoneGuest = resultSet.getString(2);
                String status = resultSet.getString(3);
                String name = resultSet.getString(7);
                String surname = resultSet.getString(8);
                int roomClass = Integer.parseInt(resultSet.getString(4));
                DateTime dateSettlement = new DateTime(resultSet.getDate(5).getTime());
                DateTime dateEviction = new DateTime(resultSet.getDate(6).getTime());
                DateTime bookingDate = new DateTime(resultSet.getDate(9).getTime());

                booking = new Booking(phoneGuest, status, name, surname, roomClass, dateSettlement, dateEviction, id, bookingDate);

                bookingList.add(booking);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


        return bookingList;
    }

    @Override
    public Booking findBookingById(int id) {

        String sql = "SELECT phone_guest, status, class_room, date_of_settlement, date_of_eviction, employee, name_guest, surname_guest FROM booking WHERE id = ?";

        try (Connection connection = dataSource.getConnection()
        ) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
//            List<Booking> bookingList = new ArrayList<>();
            Booking booking = null;
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                String phoneGuest = resultSet.getString("phone_guest");
                String status = resultSet.getString("status");
                int roomClass = Integer.parseInt(resultSet.getString("class_room"));
                DateTime dateSettlement = new DateTime(resultSet.getDate("date_of_settlement").getTime());
                DateTime dateEviction = new DateTime(resultSet.getDate("date_of_eviction").getTime());
                int employee = Integer.parseInt(resultSet.getString("employee"));
                String name = resultSet.getString("name_guest");
                String surname = resultSet.getString("surname_guest");

                booking = new Booking(id, employee, phoneGuest, status, name, surname, roomClass, dateSettlement, dateEviction);

//                bookingList.add(booking);
            }

            return booking;

//            return bookingList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean activateBookinById(int id) {
        String sql = "UPDATE booking set status = 'confirmed' WHERE id = ?";
        int add = 0;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

//            preparedStatement.setString(1,"active");
            preparedStatement.setInt(1, id);

            add = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return add > 0;    }

    @Override
    public boolean deleteBooking(int id) {

        String deleteBooking = "DELETE FROM booking " +
                "WHERE id = ?";
        boolean result = false;
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(deleteBooking);
            preparedStatement.setInt(1,id);
            result = preparedStatement.executeUpdate()==1;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }

    private DateTime getCurrentDateTime(){
        return new DateTime().withTimeAtStartOfDay();
    }
}
