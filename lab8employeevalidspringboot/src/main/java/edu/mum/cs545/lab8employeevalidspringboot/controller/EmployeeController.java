package edu.mum.cs545.lab8employeevalidspringboot.controller;

import edu.mum.cs545.lab8employeevalidspringboot.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.FileNotFoundException;

@Controller
public class EmployeeController {

    @Autowired
    ServletContext servletContext;

    private static final Log logger = LogFactory.getLog(EmployeeController.class);

    @RequestMapping(value = {"/","/employee_input" })
    public String inputEmployee(@ModelAttribute("employee") Employee employee) {
        return "EmployeeForm";
    }

    @RequestMapping(value = "/employee_save")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult,
                               Model model, HttpServletRequest request) throws FileNotFoundException {
        System.out.println(employee);
        if (bindingResult.hasErrors()) {
            return "EmployeeForm";
        }

        String[] suppressedFields = bindingResult.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Attempt to bind fields that haven't been allowed in initBinder(): "
                    + StringUtils.addStringToArray(suppressedFields, ", "));
        }

        MultipartFile image = employee.getImage();
        String rootDirectory = servletContext.getRealPath("/");
        System.out.println(rootDirectory);
        System.out.println(rootDirectory+employee.getId()+".png");

        //isEmpty means file exists BUT NO Content
        if (image!=null && !image.isEmpty()) {
            try {
                image.transferTo(new File(rootDirectory+employee.getId()+".png"));
                System.out.println("============================================");
                System.out.println(rootDirectory+employee.getId()+".png");
                model.addAttribute("imageFile",rootDirectory+employee.getId()+".png");
            } catch (Exception e) {
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
                throw new FileNotFoundException("Unable to save image: " + image.getOriginalFilename() );
            }
        }
        // save product here
        model.addAttribute("employee", employee);

        return "EmployeeDetails";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // binder.setDisallowedFields(new String[]{"firstName"});
    }

}
