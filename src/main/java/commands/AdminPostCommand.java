package commands;

import DAO.EmployeeDAO;
import DTO.Employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by edik2 on 04.07.2018.
 */
public class AdminPostCommand implements Command {

    EmployeeDAO employeeDAO;

    public AdminPostCommand(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();

        int id = Integer.parseInt(login);

        Employee employee = employeeDAO.findById(id);

        if (employee == null){
            session.setAttribute("admin", null);
            resp.sendRedirect("/admin");
            return;
        }

        if (password.equals(employee.getPassword())){
            session.setAttribute("admin", id);
            resp.sendRedirect("/checkin");
        }else {
            session.setAttribute("admin", null);
            resp.sendRedirect("/admin");
        }
    }
}
