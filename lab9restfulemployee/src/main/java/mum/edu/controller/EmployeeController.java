package mum.edu.controller;

import javax.validation.Valid;

import mum.edu.exception.EmployeeException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import mum.edu.domain.Employee;
 
@Controller
public class EmployeeController {
    @GetMapping("/")
    public String getEmpForm(){
        return "employee";
    }

    @CrossOrigin(value = "http://localhost:8080", maxAge = 6000)
    @PostMapping("/add")
    public @ResponseBody Employee add(@Valid  @RequestBody  Employee employee)  throws EmployeeException{

        if (employee.getFirstName().equals("Ex")) {
            throw new EmployeeException(employee.getEmail(), "Unable to save employee with email: ");
        }

        return employee;
    }
	
	
}
