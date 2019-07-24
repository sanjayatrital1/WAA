package edu.mum.controller;

import edu.mum.domain.Calculator;
import edu.mum.service.CalculatorService;
import edu.mum.validator.CalcValidator;
import mum.edu.framework.annotation.AutoWired;
import mum.edu.framework.annotation.Controller;
import mum.edu.framework.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.util.List;


@Controller
public class CalculatorController {
    @AutoWired
    CalcValidator validator;
    @AutoWired
    CalculatorService calculatorService;

    @RequestMapping(value="/calculatorResult" )
    public String handleCalculator(Calculator calculator, HttpServletRequest request) {
        List<String> errors = validator.validate(calculator);
        if (errors.isEmpty()) {
            calculatorService.add(calculator);
            calculatorService.mult(calculator);
            request.setAttribute("calculator", calculator);
            return "/WEB-INF/jsp/result.jsp";

        } else {

            request.setAttribute("error", errors);
            return "/WEB-INF/jsp/calculator.jsp";

        }
    }

    @RequestMapping(value={"/","/Calculator"} )
    public String getCalculator(Calculator calculator){
        return "/WEB-INF/jsp/calculator.jsp";
    }
}
