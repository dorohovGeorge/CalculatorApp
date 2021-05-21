package com.example.calculatorapp.controller;

import com.example.calculatorapp.model.Calculation;
import com.example.calculatorapp.repos.CalculationRepo;
import com.example.calculatorapp.service.CalcServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculations")
public class CalculationController {
    @Autowired
    private CalcServiceImpl calcService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculationController.class);

    @GetMapping("/hello")
    public String hello() {
        return "Калькулятор работает!";
    }

    @PostMapping("/calc")
    public ResponseEntity<Calculation> create(@RequestBody Calculation calc) {
        if (calc == null) {
            throw new RuntimeException("calc is null");
        }
        switch (calc.getAction()) {
            case "plus":
                calc.plus();
                break;
            case "minus":
                calc.minus();
                break;
            case "multi":
                calc.multiply();
                break;
            case "division":
                if(calc.getSecondNumber() == 0) {
                    LOGGER.warn("Division on zero");
                    calc.setFirstNumber(0.0);
                    calc.setResult(0.0);
                    calc.setResult(0.0);
                    calc.setAction("Divide by null");
                    break;
                }
                calc.division();
                break;
        }
        calcService.create(calc);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/calc")
    public ResponseEntity<Double> read() {
        Calculation calc = this.calcService.read();
        if (calc == null) {
            throw new RuntimeException("Not found user");
        }
        return new ResponseEntity<Double>(calc.getResult(), HttpStatus.OK);
    }

    @PutMapping("/calc")
    public ResponseEntity<Calculation> update(@RequestBody Calculation calc) {
        if (calc == null) {
            throw new RuntimeException("calc is null");
        }
        Calculation tempCalc = this.calcService.read();
        calc.setFirstNumber(tempCalc.getResult());
        switch (calc.getAction()) {
            case "plus":
                calc.plus();
                break;
            case "minus":
                calc.minus();
                break;
            case "multi":
                calc.multiply();
                break;
            case "division":
                if(calc.getSecondNumber() == 0) {
                    LOGGER.warn("Division on zero");
                    break;
                }
                calc.division();
                break;
        }
        calcService.update(calc);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/calc")
    public ResponseEntity<Calculation> delete() {
        this.calcService.delete();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
