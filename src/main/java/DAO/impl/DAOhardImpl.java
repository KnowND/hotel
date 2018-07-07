package DAO.impl;

import DAO.BookingDAO;
import DAO.DAOhard;
import DAO.EmployeeDAO;
import DAO.GuestDAO;
import DTO.*;
import org.joda.time.DateTime;
import org.joda.time.Period;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by edik2 on 16.05.2018.
 */
public class DAOhardImpl implements DAOhard {

    private Connection connection1;

    private GuestDAO guestDAO;

    private BookingDAO bookingDAO;
    private EmployeeDAO employeeDAO;

    public DAOhardImpl(DataSource dataSource, GuestDAO guestDAO, BookingDAO bookingDAO, EmployeeDAO employeeDAO) throws SQLException {
        this.connection1 = dataSource.getConnection();
        this.guestDAO = guestDAO;
        this.bookingDAO = bookingDAO;
        this.employeeDAO = employeeDAO;
    }

    public int isFreeRoomLevel(DateTime dateSettlement, DateTime dateEviction, int level) throws SQLException {

        String getBusyFromBooking = "SELECT count(*) AS total_booking FROM booking " +
                "WHERE ((date_of_settlement <= ? AND date_of_eviction > ?) OR ( date_of_settlement < ? AND date_of_eviction >= ?)) AND class_room = ?";

        String getBusyFromInHotel = "SELECT count(*) AS total_in_hotel FROM in_hotel " +
                "WHERE ((date_of_settlement <= ? AND date_of_eviction > ?) OR ( date_of_settlement < ? AND date_of_eviction >= ?)) AND class_room = ?";

        String getTotalRooms = "SELECT count(*) as total_rooms FROM room " +
                "WHERE class = ?";

        DateTime now = getCurrentDateTime();


        if (dateSettlement.getMillis() - now.getMillis() <= 0 || now.compareTo(dateEviction) > 0) return 0;

//        Period period = new Period(dateSettlement, dateEviction);

//        if (period.toStandardDays().getDays() <= 0 || dateEviction.compareTo(dateSettlement) <= 0) {
//            return 0;
//        }


        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatementInHotel = null;
        PreparedStatement preparedStatementLevel = null;
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;
        int totalBooking = 0;
        int totalInHotel = 0;
        int totalRooms = 0;

        try {
            connection = connection1;
//            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(getBusyFromBooking);

            Date settlement = new Date(dateSettlement.getMillis());
            Date eviction = new Date(dateEviction.getMillis());

            preparedStatement.setDate(1, settlement);
            preparedStatement.setDate(2, settlement);
            preparedStatement.setDate(3, eviction);
            preparedStatement.setDate(4, eviction);
            preparedStatement.setInt(5, level);

            resultSet = preparedStatement.executeQuery();

            resultSet.next();

            totalBooking = resultSet.getInt("total_booking");


            preparedStatementInHotel = connection.prepareStatement(getBusyFromInHotel);

            preparedStatementInHotel.setDate(1, settlement);
            preparedStatementInHotel.setDate(2, settlement);
            preparedStatementInHotel.setDate(3, eviction);

            preparedStatementInHotel.setDate(4, eviction);
            preparedStatementInHotel.setInt(5, level);


            resultSet = preparedStatementInHotel.executeQuery();

            resultSet.next();

            totalInHotel = resultSet.getInt("total_in_hotel");

            preparedStatementLevel = connection.prepareStatement(getTotalRooms);

            preparedStatementLevel.setInt(1, level);

            resultSet2 = preparedStatementLevel.executeQuery();

            resultSet2.next();

            totalRooms = resultSet2.getInt("total_rooms");

//            connection.commit();


        } catch (SQLException e) {
            e.printStackTrace();
//            connection.rollback();

        } finally {

//            if (connection != null) connection.close();
            if (preparedStatementInHotel != null) preparedStatementInHotel.close();
            if (preparedStatementLevel != null) preparedStatementLevel.close();


        }

        return totalRooms - totalBooking - totalInHotel;
    }

    public String checkIn(Guest guest, int room, int cost) throws SQLException {

        int g = guestDAO.addGuest(guest);

        Booking booking = bookingDAO.findBookingByGuestNameAndSurname(guest.getName(), guest.getSurname());

        if (booking == null) {
            return "cant find this booking";
        }

        DateTime dateSettlement = booking.getDateOfSettlement();
        DateTime dateEviction = booking.getDateOfEviction();

        long period = dateEviction.getMillis() - dateSettlement.getMillis();

        if (period < 0) return "wrong period (date of settlement and day of eviction)";

        DateTime now = getCurrentDateTime();

//        if (now.getMillis() - dateSettlement.getMillis() != 0){
//            return "wrong period (date of settlement and now date)";
//        }

        String getGuestByPasspport = "SELECT id " +
                "FROM guest " +
                "WHERE passport = ?";

        String deleteBooking = "DELETE FROM booking " +
                "WHERE id = ?";

        String updateRoom = "UPDATE room SET busy = TRUE WHERE id = ?";

        String insertInHotel = "INSERT INTO in_hotel(guest, employee, date_of_settlement, date_of_eviction, room, cost, class_room) " +
                "VALUES (?,?,?,?,?,?,?)";

        Connection connection = null;
        PreparedStatement preparedStatementDelete = null;
        PreparedStatement preparedStatementInsert = null;
        PreparedStatement preparedStatementGetGuest = null;
        PreparedStatement preparedStatementGetRoom = null;

        ResultSet resultSet = null;

        int delete = 0;
        int insert = 0;
        int roomUpdate = 0;

        try {

            connection = connection1;

            connection.setAutoCommit(false);

            preparedStatementGetGuest = connection.prepareStatement(getGuestByPasspport);
            preparedStatementGetGuest.setString(1, guest.getPassport());
            resultSet = preparedStatementGetGuest.executeQuery();
            resultSet.next();
            int id = resultSet.getInt("id");

            preparedStatementGetRoom = connection.prepareStatement(updateRoom);
            preparedStatementGetRoom.setInt(1, room);
            roomUpdate = preparedStatementGetRoom.executeUpdate();


            InHotel inHotel = new InHotel(id, 1, booking.getDateOfSettlement(), booking.getDateOfEviction(), room, cost, booking.getRoomClass());

            preparedStatementDelete = connection.prepareStatement(deleteBooking);
            preparedStatementDelete.setInt(1, booking.getId());
            delete = preparedStatementDelete.executeUpdate();
            preparedStatementInsert = connection.prepareStatement(insertInHotel);

            preparedStatementInsert.setInt(1, id);
            preparedStatementInsert.setInt(2, inHotel.getEmployee());
            preparedStatementInsert.setDate(3, new Date(inHotel.getDateOfSettlement().getMillis()));
            preparedStatementInsert.setDate(4, new Date(inHotel.getDateOfEviction().getMillis()));
            preparedStatementInsert.setInt(5, inHotel.getRoom());
            preparedStatementInsert.setInt(6, inHotel.getCost());
            preparedStatementInsert.setInt(7, inHotel.getClassRoom());

            insert = preparedStatementInsert.executeUpdate();

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();

            connection.rollback();

        } finally {

//            if (connection != null) connection.close();
//            if (preparedStatementDelete != null) preparedStatementDelete.close();
//            if (preparedStatementInsert != null) preparedStatementInsert.close();

        }

        return delete + insert + roomUpdate == 3?"checking successful":"checking fail";
    }

    public boolean checkOut(String passport) throws SQLException {

        String getGuestByPasspport = "SELECT id, first_name, surname, phone " +
                "FROM guest " +
                "WHERE passport = ?";


        String getInHotel = "SELECT id, guest, employee, room, cost, date_of_settlement, date_of_eviction, class_room " +
                "FROM in_hotel " +
                "WHERE guest = ?";

        String updateRoom = "UPDATE room SET busy = FALSE WHERE id = ?";


        String deleteInHotel = "DELETE FROM in_hotel " +
                "WHERE id = ?";

        String insertHistory = "INSERT INTO history(room, cost, guest, employee, date_of_settlement, date_of_eviction, guestId, employeeId) " +
                "VALUES (?,?,?,?,?,?,?,?)";

        Connection connection = null;
        PreparedStatement preparedStatementGetGuest = null;
        PreparedStatement preparedStatementGet = null;
        PreparedStatement preparedStatementDelete = null;
        PreparedStatement preparedStatementInsert = null;
        PreparedStatement preparedStatementRoomUpdate = null;

        ResultSet resultSetGet = null;

        InHotel inHotel = null;

        int get = 0;
        int delete = 0;
        int insert = 0;


        try {

            connection = connection1;

            connection.setAutoCommit(false);
            preparedStatementGetGuest = connection.prepareStatement(getGuestByPasspport);
            preparedStatementGetGuest.setString(1, passport);
            resultSetGet = preparedStatementGetGuest.executeQuery();

            resultSetGet.next();

            int idGuest = resultSetGet.getInt("id");

            if (idGuest == 0){
                throw new SQLException("didnt find guest");
            }

            String name = resultSetGet.getString("first_name");
            String surname = resultSetGet.getString("surname");
            String phone = resultSetGet.getString("phone");

            Guest guest = new Guest(idGuest, name, surname, phone, passport);
            preparedStatementGet = connection.prepareStatement(getInHotel);
            preparedStatementGet.setInt(1, guest.getId());
            resultSetGet = preparedStatementGet.executeQuery();

            while (resultSetGet.next()) {
                int id = resultSetGet.getInt("id");
                int room = resultSetGet.getInt("room");
                int cost = resultSetGet.getInt("cost");
                int classRoom = resultSetGet.getInt("class_room");
                int guestId = resultSetGet.getInt("guest");
                int employeeId = resultSetGet.getInt("employee");
                DateTime dateSettlement = new DateTime(resultSetGet.getDate("date_of_settlement").getTime());
                DateTime dateEviction = new DateTime(resultSetGet.getDate("date_of_eviction").getTime());

                inHotel = new InHotel(id, guestId, employeeId, dateSettlement, dateEviction, room, cost, classRoom);
            }

            preparedStatementRoomUpdate = connection.prepareStatement(updateRoom);
            preparedStatementRoomUpdate.setInt(1,inHotel.getRoom());
            preparedStatementRoomUpdate.executeUpdate();

            preparedStatementDelete = connection.prepareStatement(deleteInHotel);
            preparedStatementDelete.setInt(1, inHotel.getId());
            delete = preparedStatementDelete.executeUpdate();
            String nameSurnameGuest = guest.getName() + " " + guest.getSurname();
            Employee employee = employeeDAO.findById(inHotel.getEmployee());

            String nameSurnameEmployee = employee.getName() + " " + employee.getSurname();

            History history = new History(inHotel.getRoom(), inHotel.getCost(), nameSurnameGuest, nameSurnameEmployee, inHotel.getDateOfSettlement(), inHotel.getDateOfEviction(), inHotel.getGuest(), inHotel.getEmployee());

            preparedStatementInsert = connection.prepareStatement(insertHistory);
            preparedStatementInsert.setInt(1, history.getRoom());
            preparedStatementInsert.setInt(2, history.getCost());
            preparedStatementInsert.setString(3, history.getGuest());
            preparedStatementInsert.setString(4, history.getEmployee());
            preparedStatementInsert.setDate(5, new Date(history.getDateSettlement().getMillis()));
            preparedStatementInsert.setDate(6, new Date(history.getDateEviction().getMillis()));
            preparedStatementInsert.setInt(7, history.getGuestId());
            preparedStatementInsert.setInt(8, history.getEmployeeId());


            insert = preparedStatementInsert.executeUpdate();

            connection.commit();


        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();

        } finally {

//            if (connection != null) connection.close();
            if (preparedStatementGet != null) preparedStatementGet.close();
            if (preparedStatementDelete != null) preparedStatementDelete.close();
            if (preparedStatementInsert != null) preparedStatementInsert.close();
            if (resultSetGet != null) resultSetGet.close();

        }

        return delete + insert == 2;
    }

    private DateTime getCurrentDateTime() {

        return new DateTime().withTimeAtStartOfDay();
    }
}
