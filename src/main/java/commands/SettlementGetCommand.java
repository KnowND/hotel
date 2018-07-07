package commands;

import DAO.BookingDAO;
import DTO.Booking;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by edik2 on 05.06.2018.
 */
public class SettlementGetCommand implements Command {

    private BookingDAO bookingDAO;

    public SettlementGetCommand(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {


        String id = req.getParameter("id");

        if (id == null){
            resp.sendRedirect("/newguest");
            return;
        }

        int bookingId = Integer.parseInt(id);



        HttpSession session = req.getSession();

        Booking booking = bookingDAO.findBookingById(bookingId);

        if (booking != null){
            session.setAttribute("bookingOne", booking);
            session.setAttribute("booking", null);
        }

        resp.sendRedirect("/newguest");

    }
}
