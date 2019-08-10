package edu.mum.cs545.lab11authentication.service;

import edu.mum.cs545.lab11authentication.domain.Employee;
import edu.mum.cs545.lab11authentication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
   @Autowired
   private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeeByNumber(String phone) {
        return employeeRepository.locateOneEmployeeByHisNumber(phone);
    }
}
