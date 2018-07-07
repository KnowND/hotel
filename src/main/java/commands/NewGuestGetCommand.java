package commands;

import DAO.RoomDAO;
import DTO.Booking;
import DTO.Room;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by edik2 on 12.06.2018.
 */
public class NewGuestGetCommand implements Command {

    RoomDAO roomDAO;

    public NewGuestGetCommand(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        HttpSession session = req.getSession();

        Booking booking = (Booking) session.getAttribute("bookingOne");

        if (booking == null){
            session.setAttribute("new", true);
//            resp.sendRedirect("/checkin");
            req.getRequestDispatcher("guestRegistration.jsp").forward(req,resp);

            return;
        }

        session.setAttribute("new", false);
        req.setAttribute("guestName", booking.getNameGuest());
        req.setAttribute("guestSurname", booking.getSurnameGuest());
        req.setAttribute("guestPhone", booking.getPhoneGuest());

        List<Room> roomList = roomDAO.getAllRoomThisLevel(booking.getRoomClass());

        session.setAttribute("rooms", roomList);

        req.getRequestDispatcher("guestRegistration.jsp").forward(req,resp);
    }
}
