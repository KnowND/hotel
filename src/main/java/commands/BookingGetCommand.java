package commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by edik2 on 27.05.2018.
 */
public class BookingGetCommand implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        req.getRequestDispatcher("booking.jsp").forward(req, resp);

    }
}
