package commands;

import DAO.DAOhard;
import DAO.impl.DAOhardImpl;
import DTO.Guest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by edik2 on 21.05.2018.
 */
public class CheckingCommand implements Command {

    private DAOhard daOhard;

    public CheckingCommand(DAOhard daOhard) {
        this.daOhard = daOhard;
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String phone = req.getParameter("phone");
        String passport = req.getParameter("passport");
        String code = req.getParameter("code");
        HttpSession session = req.getSession();
        String r = req.getParameter("room");
        String c = req.getParameter("cost");

        if ( r == null || c == null || name == null || surname == null || phone == null || code == null || passport == null ||
                name.length() == 0 || surname.length() == 0 || passport.length() == 0 || phone.length() != 10 || r.length() == 0 || c.length() == 0){
            session.setAttribute("wrong_cheking", true);
            resp.sendRedirect("/newguest");
            return;
        }



        String reg = "\\d+";

        if (!(r.matches(reg) && c.matches(reg)) ){
            session.setAttribute("wrong_cheking", true);
            resp.sendRedirect("/newguest");
            return;
        }

        session.setAttribute("wrong_cheking", false);

        int room = Integer.parseInt(r);
        int cost = Integer.parseInt(c);

        Guest guest = new Guest(name,surname,phone,passport);

        if ((boolean)session.getAttribute("new")){

        }

        String ckecking = daOhard.checkIn(guest, room, cost);

        System.out.println(ckecking);
        resp.sendRedirect("/checkout");
//        if (daOhard.checkIn(guest, room, cost)){
//            resp.sendRedirect("/booking");
//        }else {
//            resp.sendRedirect("/error");
//        }


    }
}
