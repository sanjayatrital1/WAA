package edu.mum.validator;

import edu.mum.domain.Calculator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalcValidatorImpl implements CalcValidator {
    @Override
    public List<String> validate(Object obj) {
        List<String>error = new ArrayList<>();
        Calculator calculator = (Calculator)obj;
        Integer add1 = calculator.getAdd1();
        if(add1==null){
            error.add("Must have value");
        }
        Integer add2 = calculator.getAdd1();
        if(add2==null){
            error.add("Must have value");
        }
        Integer mult1 = calculator.getAdd1();
        if(mult1==null){
            error.add("Must have value");
        }
        Integer mult2 = calculator.getAdd1();
        if(mult2==null){
            error.add("Must have value");
        }
        return error;
    }
}
