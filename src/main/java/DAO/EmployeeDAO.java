package DAO;

import DTO.Employee;

/**
 * Created by edik2 on 15.05.2018.
 */
public interface EmployeeDAO {

    int addEmployee(Employee employee);

    Employee findById(int id);

}
