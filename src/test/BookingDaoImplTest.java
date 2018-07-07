import DAO.BookingDAO;
import DAO.DAOhard;
import DAO.EmployeeDAO;
import DAO.GuestDAO;
import DAO.impl.BookingDAOImpl;
import DAO.impl.DAOhardImpl;
import DAO.impl.EmployeeDAOImpl;
import DAO.impl.GuestDAOImpl;
import DTO.Booking;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;


/**
 * Created by edik2 on 27.05.2018.
 */
public class BookingDaoImplTest extends BaseDAOTest {

    private BookingDAO bookingDAO;
    private DAOhard daOhard;
    private GuestDAO guestDAO;
    private EmployeeDAO employeeDAO;
    private DateTime dateSettlement;
    private DateTime dateEviction;


    @Before
    public void startUp() throws SQLException {

        bookingDAO = new BookingDAOImpl(dataSource.getDS());
        guestDAO = new GuestDAOImpl(dataSource.getDS());
        employeeDAO = new EmployeeDAOImpl(dataSource.getDS());
        daOhard = new DAOhardImpl((DataSource) dataSource, guestDAO, bookingDAO, employeeDAO);

    }


    @Test
    public void test_Booking() throws SQLException {
        Booking booking;
        dateSettlement = new DateTime().plusDays(7);
        dateEviction = new DateTime().plusDays(23);

        booking = new Booking(0, "34563730", "Elina", "Kulyk", 1, dateSettlement, dateEviction);

        assertEquals(2, daOhard.isFreeRoomLevel(dateSettlement, dateEviction, 0));
        assertEquals(2, daOhard.isFreeRoomLevel(dateSettlement, dateEviction, 1));


        assertEquals(1, bookingDAO.addBooking(booking));

        dateSettlement = new DateTime().plusHours(1);
        dateEviction = new DateTime().plusDays(8);

        booking = new Booking(0, "34563730", "Elina", "Kulyk", 1, dateSettlement, dateEviction);

        assertEquals(1, bookingDAO.addBooking(booking));


        Booking booking2 = bookingDAO.findBookingByGuestNameAndSurname("Elina", "Kulyk");

        assertEquals("Elina", booking2.getNameGuest());
        assertEquals("Kulyk", booking2.getSurnameGuest());

        assertEquals(0, daOhard.isFreeRoomLevel(dateSettlement, dateEviction, 1));


/////////////////////////////////////

        dateSettlement = new DateTime().plusDays(7);
        dateEviction = new DateTime().plusDays(9);

        assertEquals(0, daOhard.isFreeRoomLevel(dateSettlement, dateEviction, 1));

/////////////////////////////////////

        dateSettlement = new DateTime().plusDays(10);
        dateEviction = new DateTime().plusDays(15);

        assertEquals(1, daOhard.isFreeRoomLevel(dateSettlement, dateEviction, 1));

/////////////////////////////////////


        dateSettlement = new DateTime().plusDays(1);
        dateEviction = new DateTime().plusDays(7);
        assertEquals(1, daOhard.isFreeRoomLevel(dateSettlement, dateEviction, 1));

        /////////////////////////////////////


        dateSettlement = new DateTime().plusDays(1);
        dateEviction = new DateTime().plusDays(6);
        assertEquals(1, daOhard.isFreeRoomLevel(dateSettlement, dateEviction, 1));

        /////////////////////////////////////


        dateSettlement = new DateTime().plusDays(5);
        dateEviction = new DateTime().plusDays(5);

        assertEquals(0, daOhard.isFreeRoomLevel(dateSettlement, dateEviction, 1));

    }


    @Test
    public void test_two_bookings() throws SQLException {


        Booking booking1 = new Booking(0, "949494", "Greg", "Kulyk", 0, dateSettlement, dateEviction);
        Booking booking2 = new Booking(0, "949494", "Bob", "Kulyk", 1, dateSettlement, dateEviction);

        assertEquals(1, bookingDAO.addBooking(booking1));
        assertEquals(1, bookingDAO.addBooking(booking2));

        Booking booking02 = bookingDAO.findBookingByGuestNameAndSurname("Bob", "Kulyk");

        assertEquals("Bob", booking02.getNameGuest());
        assertEquals("Kulyk", booking02.getSurnameGuest());

        assertEquals(1, daOhard.isFreeRoomLevel(dateSettlement, dateEviction, 1));


/////////////////////////////////////
        dateSettlement = new DateTime();
        dateEviction = new DateTime().plusDays(5);

        assertEquals(1, daOhard.isFreeRoomLevel(dateSettlement, dateEviction, 1));

/////////////////////////////////////
        dateSettlement = new DateTime();
        dateEviction = new DateTime().plusDays(5);

        assertEquals(1, daOhard.isFreeRoomLevel(dateSettlement, dateEviction, 1));

/////////////////////////////////////
        dateSettlement = new DateTime();
        dateEviction = new DateTime().plusDays(5);

        assertEquals(1, daOhard.isFreeRoomLevel(dateSettlement, dateEviction, 1));

        /////////////////////////////////////
        dateSettlement = new DateTime();
        dateEviction = new DateTime().plusDays(5);

        assertEquals(2, daOhard.isFreeRoomLevel(dateSettlement, dateEviction, 1));

    }
    @Test
    public void test_bookingInThePast(){

        dateSettlement = new DateTime().minusDays(9);
        dateEviction = new DateTime().minusDays(5);

        Booking booking1 = new Booking(0, "949494", "Greg", "Kulyk", 0, dateSettlement, dateEviction);

        assertEquals(0, bookingDAO.addBooking(booking1));

    }


}
