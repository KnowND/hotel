package commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by edik2 on 04.07.2018.
 */
public class AdminGetCommand implements Command{


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.getRequestDispatcher("adminLogin.jsp").forward(req,resp);
    }
}
