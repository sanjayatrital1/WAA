package edu.mum.service;

import edu.mum.domain.Calculator;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public void add(Calculator calculator) {
       calculator.add();
    }

    @Override
    public void mult(Calculator calculator) {

        calculator.multiply();
    }
}
