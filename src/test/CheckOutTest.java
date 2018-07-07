import DAO.BookingDAO;
import DAO.DAOhard;
import DAO.EmployeeDAO;
import DAO.GuestDAO;
import DAO.impl.BookingDAOImpl;
import DAO.impl.DAOhardImpl;
import DAO.impl.EmployeeDAOImpl;
import DAO.impl.GuestDAOImpl;
import DTO.Booking;
import DTO.Employee;
import DTO.Guest;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.Date;

/**
 * Created by edik2 on 27.05.2018.
 */
public class CheckOutTest extends BaseDAOTest{

    private Booking booking;
    private BookingDAO bookingDAO;
    private DAOhard daOhard;
    private Guest guest;
    private EmployeeDAO employeeDAO;
    private GuestDAO guestDAO;
    private DateTime dateSettlement;
    private DateTime dateEviction;


    @Before
    public void startUp() throws SQLException {

        bookingDAO = new BookingDAOImpl(dataSource.getDS());
        guestDAO = new GuestDAOImpl(dataSource.getDS());
        employeeDAO = new EmployeeDAOImpl(dataSource.getDS());
        daOhard = new DAOhardImpl((DataSource) dataSource, guestDAO,bookingDAO, employeeDAO);

    }

    @Test
    public void test_checkOut() throws SQLException {

        guest = new Guest("Vasyl", "Vasilskii", "3890765421","HG1234DS");

        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");

        String settlement = "04/02/2011 20:27:05";
        String eviction = "15/02/2011 20:27:05";

        dateSettlement = formatter.parseDateTime(settlement);
        dateEviction = formatter.parseDateTime(eviction);

        booking = new Booking(0,"34563730", "Vasyl", "Vasilskii", 1, dateSettlement, dateEviction);

        assertEquals(0, bookingDAO.addBooking(booking));

        dateSettlement = new DateTime();
        dateEviction = new DateTime().plusDays(5);

        booking = new Booking(0,"3890765421", "Vasyl", "Vasilskii", 1, dateSettlement, dateEviction);

        assertEquals(1, bookingDAO.addBooking(booking));

        assertEquals(false,daOhard.checkIn(guest,3,10));

        assertEquals(true,daOhard.checkIn(guest,3,1100));

        assertEquals(true, daOhard.checkOut("HG1234DS"));


    }

}
