package DAO;

import DTO.Booking;

import java.awt.print.Book;
import java.util.List;

/**
 * Created by edik2 on 15.05.2018.
 */
public interface BookingDAO {

    int addBooking(Booking booking);

    Booking findBookingByGuestNameAndSurname(String name, String surname);

    public List<Booking> getAllBooking();

    Booking findBookingById(int id);

    boolean activateBookinById(int id);

    boolean deleteBooking(int id);

}
