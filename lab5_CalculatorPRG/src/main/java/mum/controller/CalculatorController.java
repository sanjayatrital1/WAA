package mum.controller;

import mum.domain.Calculator;
//import mum.edu.framework.annotation.Controller;
import mum.service.CalculatorService;
import mum.validator.Validator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CalculatorController {
	@Autowired
	private CalculatorService calculatorService;
	@Autowired
	private Validator validator;

	@RequestMapping(value={"/","/Calculator"} , method = RequestMethod.POST)
	public String handleCalculator(Calculator calculator, HttpServletRequest request) {
		List<String> errors = validator.validate(calculator);
		if (!errors.isEmpty()) {
			request.setAttribute("error", errors);
			return "calculator";

		} else {
			if (calculator.getAdd1() != null && calculator.getAdd2() != null) {
				calculatorService.add(calculator);
			}
			if (calculator.getMult1() != null && calculator.getMult2() != null) {
				calculatorService.mult(calculator);
			}

			return "result";
		}
	}

	@RequestMapping(value={"/","/Calculator"} , method = RequestMethod.GET)
	public String getCalculator(Calculator calculator){
		return "calculator";
	}

}
