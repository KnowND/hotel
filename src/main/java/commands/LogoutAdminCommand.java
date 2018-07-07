package commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by edik2 on 04.07.2018.
 */
public class LogoutAdminCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        if (session.getAttribute("admin") != null){
            session.setAttribute("admin", null);
            resp.sendRedirect("/check");
        }else {
            resp.sendRedirect("/check");

        }
    }
}
