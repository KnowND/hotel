package commands;

import DAO.GuestDAO;
import DAO.InHotelDAO;
import DAO.RoomDAO;
import DTO.Guest;
import DTO.InHotel;
import DTO.Room;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by edik2 on 14.06.2018.
 */
public class CheckOutGetCommand implements Command {

    private InHotelDAO inHotelDAO;
    private GuestDAO guestDAO;
    private RoomDAO roomDAO;

    public CheckOutGetCommand(InHotelDAO inHotelDAO, GuestDAO guestDAO, RoomDAO roomDAO) {
        this.guestDAO = guestDAO;
        this.inHotelDAO = inHotelDAO;
        this.roomDAO = roomDAO;
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<InHotel> inHotelList = new ArrayList<>();
        inHotelList.addAll(inHotelDAO.getAllInHotel());

        COut cOut;
        List<COut> cOuts = new ArrayList<>();

        List<Guest> listGuest = new ArrayList<>();
        for (InHotel inHotel : inHotelList) {
            Guest guest = guestDAO.getGuestById(inHotel.getGuest());
            Room room = roomDAO.getRoomById(inHotel.getRoom());
            cOut = new COut(guest.getPhone(), guest.getPassport(), guest.getName(), guest.getSurname(), inHotel.getDateSettlement(), inHotel.getDateEviction(), room.getNumber(), room.getCost());
            cOuts.add(cOut);
//            listGuest.add(guest);
        }

        req.setAttribute("inHotels", cOuts);

        req.getRequestDispatcher("checkOut.jsp").forward(req, resp);
    }
}
