package edu.mum.cs545.lab11authentication.controller;


import edu.mum.cs.lab10ormassignment.domain.Employee;
import edu.mum.cs.lab10ormassignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    private String getEmpForm(@ModelAttribute Employee employee){
        return "employeeForm";
    }

    @PostMapping("/")
    private String saveEmployee(@Valid Employee employee, BindingResult result){
        if(result.hasErrors()){
            return "employeeForm";
        }
        else {
            employeeService.save(employee);
            return "redirect:/employeeList";
        }
    }

    @GetMapping("employeeList")
    public String getEmpList(Model model){
        model.addAttribute("employeelist",employeeService.getAllEmployee());
        return "employeeList";
    }

    @GetMapping("/getByPhone")
    public String getEmployeeByPhone(@RequestParam(value = "phone", required = false) String phone,Model model){
        model.addAttribute("employeelist",employeeService.getEmployeeByNumber(phone));
        return "employeeList";
    }
}
