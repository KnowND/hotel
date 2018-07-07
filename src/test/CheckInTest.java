import DAO.*;
import DAO.impl.*;
import DTO.Booking;
import DTO.Employee;
import DTO.Guest;
import DTO.RoomLevel;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by edik2 on 27.05.2018.
 */
public class CheckInTest extends BaseDAOTest {

    private Booking booking;
    private BookingDAO bookingDAO;
    private DAOhard daOhard;
    private GuestDAO guestDAO;
    private EmployeeDAO employeeDAO;
    private RoomLevelDAO roomLevelDAO;
    private DateTime dateSettlement;
    private DateTime dateEviction;
    private Guest guest;


    @Before
    public void startUp() throws SQLException, ParseException {

        bookingDAO = new BookingDAOImpl(dataSource.getDS());
        roomLevelDAO = new RoomLevelDAOImpl(dataSource.getDS());


        guestDAO = new GuestDAOImpl(dataSource.getDS());

        employeeDAO = new EmployeeDAOImpl(dataSource.getDS());
        daOhard = new DAOhardImpl((DataSource) dataSource, guestDAO,bookingDAO, employeeDAO);

    }

    @Test
    public void test_CheckIn() throws SQLException {

        guest = new Guest("Vasyl", "Vasilskii", "3890765421","HG1234DS");

//        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
//
//        String settlement = "2/02/2011 20:27:05";
//        String eviction = "15/02/2011 20:27:05";
//
//        dateSettlement = formatter.parseDateTime(settlement);
//        dateEviction = formatter.parseDateTime(eviction);

        dateSettlement = new DateTime().plusHours(1);
        dateEviction = new DateTime().plusDays(5);

        booking = new Booking(0,"34563730", "Vasyl", "Vasilskii", 1, dateSettlement, dateEviction);

        assertEquals(1, bookingDAO.addBooking(booking));

        assertEquals(true,daOhard.checkIn(guest,0,500));


        dateSettlement = new DateTime().plusHours(1);
        dateEviction = new DateTime().plusDays(7);

        booking = new Booking(0,"34563730", "Vasyl12", "Vasilskii12", 1, dateSettlement, dateEviction);

        guest = new Guest("Vasyl12", "Vasilskii12", "3890765441","HG1234DS1");

        assertEquals(1, bookingDAO.addBooking(booking));

        assertEquals(true,daOhard.checkIn(guest,0,700));

    }

}
