package commands;

import DAO.DAOhard;
import DAO.impl.DAOhardImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by edik2 on 21.05.2018.
 */
public class CheckOutPostCommand implements Command{
    private DAOhard daOhard;

    public CheckOutPostCommand(DAOhard daOhard) {
        this.daOhard = daOhard;
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String passport = req.getParameter("passport");

        try {
            daOhard.checkOut(passport);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
