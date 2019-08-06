package edu.mum.cs.lab10ormassignment.service;


import edu.mum.cs.lab10ormassignment.domain.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee>getAllEmployee();
    Employee save(Employee employee);
    List<Employee>getEmployeeByNumber(String phone);
}
