package commands;

import DAO.RoomLevelDAO;
import DTO.RoomLevel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by edik2 on 04.06.2018.
 */
public class CheckDateGetCommand implements Command {

    RoomLevelDAO roomLevelDAO;

    public CheckDateGetCommand(RoomLevelDAO roomLevelDAO) {
        this.roomLevelDAO = roomLevelDAO;
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        List<RoomLevel> roomLevels = roomLevelDAO.getAllRoomLevel();
        req.setAttribute("roomLevel",roomLevels);

        req.getRequestDispatcher("/checkDate.jsp").forward(req, resp);

    }
}
