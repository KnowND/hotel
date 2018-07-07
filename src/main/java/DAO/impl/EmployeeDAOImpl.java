package DAO.impl;

import DAO.EmployeeDAO;
import DTO.Employee;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by edik2 on 15.05.2018.
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    private DataSource dataSource;

    public EmployeeDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int addEmployee(Employee employee) {
        String sql = "INSERT INTO emplye(first_name, surname, phone, role) VALUES (?,?,?,?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getSurname());
            preparedStatement.setString(3, employee.getPhone());
            preparedStatement.setString(4, employee.getRole());
            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
//            e.printStackTrace();
//            logger.error("Error adding record to Account table ", e);

        }
        return 0;
    }

    @Override
    public Employee findById(int id) {
        String sql = "SELECT id, first_name, surname, phone, role, password FROM employe WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            Employee employee = null;
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            int idD = Integer.parseInt(resultSet.getString(1));
            String name = resultSet.getString(2);
            String surname = resultSet.getString(3);
            String phone = resultSet.getString(4);
            String role = resultSet.getString(5);
            String password = resultSet.getString(6);

            employee = new Employee(id, name, surname, phone, role, password);

            return employee;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
