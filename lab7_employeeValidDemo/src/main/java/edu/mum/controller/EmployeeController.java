package edu.mum.controller;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.domain.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;

@Controller
public class EmployeeController {
	@Autowired
	ServletContext servletContext;

	private static final Log logger = LogFactory.getLog(EmployeeController.class);

	@RequestMapping(value =  "/employee_input" )
	public String inputEmployee(@ModelAttribute("employee") Employee employee) {
		return "EmployeeForm";
	}

	@RequestMapping(value = "/employee_save")
	public String saveEmployee(@Valid Employee emp, BindingResult bindingResult,
			Model model) throws FileNotFoundException {
		
		if (bindingResult.hasErrors()) {
			return "EmployeeForm";
		}

		String[] suppressedFields = bindingResult.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempt to bind fields that haven't been allowed in initBinder(): "
					+ StringUtils.addStringToArray(suppressedFields, ", "));
		}

		// save product here
		MultipartFile image = emp.getImage();
		String rootDirectory = servletContext.getRealPath("/");

		//isEmpty means file exists BUT NO Content
		if (image!=null && !image.isEmpty()) {
			try {
				image.transferTo(new File(rootDirectory+"/image/"+ emp.getId() + ".png"));
			} catch (Exception e) {
				throw new FileNotFoundException("Unable to save image: " + image.getOriginalFilename() );
			}
		}


		model.addAttribute("employee", emp);

		return "EmployeeDetails";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// binder.setDisallowedFields(new String[]{"firstName"});
	}
}
