package commands;

import DAO.BookingDAO;
import DTO.Booking;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by edik2 on 04.06.2018.
 */
public class CheckInGetCommand implements Command {

    private BookingDAO bookingDAO;

    public CheckInGetCommand(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Booking> bookingList = new ArrayList<>() ;
        bookingList.addAll(bookingDAO.getAllBooking());

//        req.getSession().setAttribute("booking", bookingList);
        req.getSession().setAttribute("booking", bookingList);
        req.getSession().setAttribute("delete", null);


        req.getRequestDispatcher("checkIn.jsp").forward(req,resp);
    }
}
