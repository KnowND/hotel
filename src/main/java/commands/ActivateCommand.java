package commands;

import DAO.BookingDAO;
import DTO.Booking;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by edik2 on 18.06.2018.
 */
public class ActivateCommand implements Command {

    private BookingDAO bookingDAO;

    public ActivateCommand(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        int bookingId = Integer.parseInt(req.getParameter("id"));

        boolean success = bookingDAO.activateBookinById(bookingId);

        resp.sendRedirect("/checkin");
    }
}
