package mum.controller;

import mum.domain.Calculator;
//import mum.edu.framework.annotation.Controller;
import mum.service.CalculatorService;
import mum.validator.Validator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String handleCalculator(Calculator calculator, Model model, RedirectAttributes redirectAttributes) {
		List<String> errors = validator.validate(calculator);
		if (!errors.isEmpty()) {
			model.addAttribute("error", errors);
			return "calculator";

		} else {
			if (calculator.getAdd1() != null && calculator.getAdd2() != null) {
				calculatorService.add(calculator);
			}
			if (calculator.getMult1() != null && calculator.getMult2() != null) {
				calculatorService.mult(calculator);
			}
			redirectAttributes.addFlashAttribute("calculator",calculator);
			String message ="Good Work!!!";
			redirectAttributes.addAttribute("greeting",message);

			return "redirect:/results";
		}
	}

	@GetMapping("/results")
	public String displayResult(Model model) throws Exception {
		Calculator calc = (Calculator) ((ModelMap)model).get("calculator");
		if(calc==null){
			throw new Exception("Try Again");
		}
		return "result";
	}


	@RequestMapping(value={"/","/Calculator"} , method = RequestMethod.GET)
	public String getCalculator(Calculator calculator){
		return "calculator";
	}

}
