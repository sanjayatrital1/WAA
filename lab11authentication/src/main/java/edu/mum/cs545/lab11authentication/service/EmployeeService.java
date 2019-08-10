package edu.mum.cs545.lab11authentication.service;



import edu.mum.cs545.lab11authentication.domain.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee>getAllEmployee();
    Employee save(Employee employee);
    List<Employee>getEmployeeByNumber(String phone);
}
