package commands;

import DAO.DAOhard;
import org.joda.time.DateTime;
import org.joda.time.Period;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by edik2 on 04.06.2018.
 */
public class CheckDatePostCommand implements Command {

    private DAOhard daOhard;

    public CheckDatePostCommand(DAOhard daOhard) {
        this.daOhard = daOhard;
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();

        String reg = "\\d+";
//        String sY = req.getParameter("sYear");
//        String sM = req.getParameter("sMonth");
//        String sD = req.getParameter("sDay");
//        String eY = req.getParameter("eYear");
//        String eM = req.getParameter("eMonth");
//        String eD = req.getParameter("eDay");
        String distance = req.getParameter("daterange");

        String [] src = distance.split("/");
        String sM = src[0];
        String sD = src[1];

        String eD = src[3];
        String eY = src[4];

        String [] src2 = src[2].split(" - ");

        String sY = src2[0];
        String eM = src2[1];

        if (!(sY.matches(reg) && sM.matches(reg) && sD.matches(reg) && eY.matches(reg) && eM.matches(reg) && eD.matches(reg))){
            session.setAttribute("wrong_date",true);
            resp.sendRedirect("/check");
            return;

        }

        int sYear = Integer.parseInt(sY);
        int sMonth = Integer.parseInt(sM);
        int sDay = Integer.parseInt(sD);
        int eYear = Integer.parseInt(eY);
        int eMonth = Integer.parseInt(eM);
        int eDay = Integer.parseInt(eD);

        int roomLevel = Integer.parseInt(req.getParameter("class"));


        DateTime dateSettlement = new DateTime().withYear(sYear).withMonthOfYear(sMonth).withDayOfMonth(sDay);
        DateTime dateEviction = new DateTime().withYear(eYear).withMonthOfYear(eMonth).withDayOfMonth(eDay);
        DateTime now = new DateTime().withTimeAtStartOfDay();


        long period = dateEviction.getMillis() - dateSettlement.getMillis();
        long periodFromNow = dateSettlement.getMillis() - now.getMillis();



        if (period <= 0){
            session.setAttribute("wrong_date",true);
            resp.sendRedirect("/check");
            return;

        }

        if (periodFromNow < 0){
            session.setAttribute("wrong_date",true);
            resp.sendRedirect("/check");
            return;
        }

        session.setAttribute("wrong_date",false);


        int freeRooms = daOhard.isFreeRoomLevel(dateSettlement, dateEviction, roomLevel);
        session.setAttribute("free",  freeRooms > 0);

        if (freeRooms == 0){
            resp.sendRedirect("/check");

        }else {
            String []settEvic = distance.split(" - ");
            session.setAttribute("in", settEvic[0]);
            session.setAttribute("out", settEvic[1]);
            session.setAttribute("class", roomLevel);
            session.setAttribute("settlement", dateSettlement);
            session.setAttribute("eviction", dateEviction);

            resp.sendRedirect("/booking");
        }

//        req.getRequestDispatcher("booking.jsp").forward(req, resp);


    }
}
