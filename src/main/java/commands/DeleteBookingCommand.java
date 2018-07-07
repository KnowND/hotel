package commands;

import DAO.BookingDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by edik2 on 04.07.2018.
 */
public class DeleteBookingCommand implements Command {

    private BookingDAO bookingDAO;

    public DeleteBookingCommand(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        int bookingId = Integer.parseInt(req.getParameter("id"));

        boolean success = bookingDAO.deleteBooking(bookingId);

        if (success){
            req.setAttribute("delete", bookingId);
            req.getRequestDispatcher("successDeleteBooking.jsp").forward(req,resp);
            return;
        }

        resp.sendRedirect("/checkin");

    }
}
