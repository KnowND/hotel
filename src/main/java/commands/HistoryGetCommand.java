package commands;

import DAO.GuestDAO;
import DAO.HistoryDAO;
import DAO.RoomDAO;
import DTO.Guest;
import DTO.History;
import DTO.Room;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by edik2 on 03.07.2018.
 */
public class HistoryGetCommand implements Command {

    private HistoryDAO historyDAO;
    private RoomDAO roomDAO;

    public HistoryGetCommand(HistoryDAO historyDAO, RoomDAO roomDAO) {
        this.historyDAO = historyDAO;
        this.roomDAO = roomDAO;
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<History> historyList = historyDAO.getAllHistory();
        List<Historys> historys = new ArrayList<>();
        if (historyList != null) {

            for (History history : historyList) {
                Room room = roomDAO.getRoomById(history.getRoom());

                Historys historys1 = new Historys(history.getId(), history.getGuest(), history.getEmployee(), history.getDateSettlement(), history.getDateEviction(), room.getNumber(), room.getCost(), history.getGuestId(), history.getEmployeeId(), history.getEmployee());
                historys.add(historys1);

            }

            req.setAttribute("history", historys);


        }
        req.getRequestDispatcher("history.jsp").forward(req, resp);

    }
}
