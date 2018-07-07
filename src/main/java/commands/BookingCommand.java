package commands;

import DAO.BookingDAO;
import DTO.Booking;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by edik2 on 21.05.2018.
 */
public class BookingCommand implements Command {

    BookingDAO bookingDAO;

    public BookingCommand(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

//        String sYear = req.getParameter("sYear");
//        String sMonth = req.getParameter("sMonth");
//        String sDay = req.getParameter("sDay");
//        String eYear = req.getParameter("eYear");
//        String eMonth = req.getParameter("eMonth");
//        String eDay = req.getParameter("eDay");
        String phone = req.getParameter("phone");
        String nameGuest = req.getParameter("name");
        String surnameGuest = req.getParameter("surname");
        HttpSession session = req.getSession();


        if (phone.length() == 0 || nameGuest.length() == 0 || surnameGuest.length() == 0){
            resp.sendRedirect("/booking");
            session.setAttribute("wrong_guest", true);
            return;
        }
        session.setAttribute("wrong_guest", false);

        DateTime dateSettlement = (DateTime) session.getAttribute("settlement");
        DateTime dateEviction = (DateTime) session.getAttribute("eviction");


        int roomLevel = (int) session.getAttribute("class");

        Booking booking = new Booking(0,phone, nameGuest,surnameGuest, roomLevel,dateSettlement,dateEviction);

        if (bookingDAO.addBooking(booking) == 1) {

            session.setAttribute("settlement", null);
            session.setAttribute("in", null);
            session.setAttribute("out", null);
            session.setAttribute("eviction", null);
            session.setAttribute("free", null);
            session.setAttribute("wrong",null);
            session.setAttribute("success",true);
            req.getRequestDispatcher("successBooking.jsp").forward(req,resp);
        }else {
            session.setAttribute("wrong",true);
            resp.sendRedirect("/booking");
        }



    }
}
