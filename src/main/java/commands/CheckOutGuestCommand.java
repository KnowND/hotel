package commands;

import DAO.DAOhard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by edik2 on 22.06.2018.
 */
public class CheckOutGuestCommand implements Command {

    DAOhard daOhard;

    public CheckOutGuestCommand(DAOhard daOhard) {
        this.daOhard = daOhard;
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String passport = req.getParameter("passport");

        try {
            daOhard.checkOut(passport);
            resp.sendRedirect("/checkout");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
