package controller;

import DAO.*;
import DAO.connection.DataSourcePool;
import DAO.impl.*;
import DTO.InHotel;
import commands.*;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by edik2 on 17.01.2018.
 */
//@WebServlet(urlPatterns = "/")
public class MainController extends HttpServlet {
    private static final Logger logger = Logger.getLogger(MainController.class);

    Map<String, Command> commandMap;

    //    DataSourcePool dataSourcePool;
    private DataSourcePool dataSourcePool;
    Command command;

    @Override
    public void init() {

//        DAOFactory daoFactory = DAOFactoryImpl.INSTANCE;
//        dataSourcePool = DataSourcePool.INSTANCE;
        DataSource dataSource;
        Connection connection;
        dataSourcePool = new DataSourcePool("database");
        dataSource = dataSourcePool.getDS();

        try{
            connection = dataSourcePool.getConnection();

        }catch (SQLException e){
            e.printStackTrace();
        }

        BookingDAO bookingDAO = new BookingDAOImpl(dataSource);
        GuestDAO guestDAO = new GuestDAOImpl(dataSource);
        EmployeeDAO employeeDAO = new EmployeeDAOImpl(dataSource);
        InHotelDAO inHotelDAO = new InHotelDAOImpl(dataSource);
        HistoryDAO historyDAO = new HistoryDAOImpl(dataSource);
        RoomDAO roomDAO = new RoomDAOImpl(dataSource);
        RoomLevelDAO roomLevelDAO = new RoomLevelDAOImpl(dataSource);
        DAOhard daOhard = null;
        try {
            daOhard = new DAOhardImpl(dataSource,guestDAO,bookingDAO,employeeDAO);

        }catch (SQLException e){
            e.printStackTrace();
        }

        commandMap = new HashMap<>();

        commandMap.put("/booking_get", new BookingGetCommand());
        commandMap.put("/booking_post", new BookingCommand(bookingDAO));
        commandMap.put("/check_get", new CheckDateGetCommand(roomLevelDAO));
        commandMap.put("/admin_get", new AdminGetCommand());
        commandMap.put("/admin_post", new AdminPostCommand(employeeDAO));
        commandMap.put("/check_post", new CheckDatePostCommand(daOhard));
        commandMap.put("/logout_get", new LogoutAdminCommand());
        commandMap.put("/checkin_get", new CheckInGetCommand(bookingDAO));
        commandMap.put("/deletebook_get", new DeleteBookingCommand(bookingDAO));
        commandMap.put("/checkin_post", new CheckingCommand(daOhard));
        commandMap.put("/checkout_get", new CheckOutGetCommand(inHotelDAO,guestDAO,roomDAO));
        commandMap.put("/checkoutguest_get", new CheckOutGuestCommand(daOhard));
        commandMap.put("/checkout_post", new CheckingCommand(daOhard));
        commandMap.put("/newguest_get", new NewGuestGetCommand(roomDAO));
        commandMap.put("/history_get", new HistoryGetCommand(historyDAO, roomDAO));
        commandMap.put("/newguest_post", new CheckInGetCommand(bookingDAO));
        commandMap.put("/settlement_get", new SettlementGetCommand(bookingDAO));
        commandMap.put("/activate_get", new ActivateCommand(bookingDAO));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uri = req.getRequestURI();
        command = commandMap.get(uri + "_get");

        try {
            executeCommand(req, resp, command);
        } catch (Exception e) {
            e.printStackTrace();
//            logger.error("Error executing command " + command.getClass().getName(), e);
//            resp.sendRedirect("/error");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uri = req.getRequestURI();
        command = commandMap.get(uri + "_post");

        try {
            executeCommand(req, resp, command);
        } catch (Exception e) {
//            logger.error("Error executing command " + command != null ? command.getClass().getName() : "Command doesnt exist", e);
            e.printStackTrace();
//            resp.sendRedirect("/error");
        }

    }

    private void executeCommand(HttpServletRequest req, HttpServletResponse resp, Command command) throws Exception {
        if (command != null) {
            command.execute(req, resp);
        }
    }

    @Override
    public void destroy() {
        try {
            dataSourcePool.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
