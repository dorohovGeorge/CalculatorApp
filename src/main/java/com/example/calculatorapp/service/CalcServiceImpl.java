package com.example.calculatorapp.service;

import com.example.calculatorapp.model.Calculation;
import com.example.calculatorapp.repos.CalculationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalcServiceImpl implements CalcService {
    @Autowired
    private CalculationRepo calculationRepo;

    @Override
    public void create(Calculation calc) {
        calc.setId(1L);
        calculationRepo.save(calc);
    }

    @Override
    public Calculation read() {
        return calculationRepo.findById(1l).orElse(null);
    }

    @Override
    public boolean delete() {
        if (calculationRepo.existsById(1L)) {
            calculationRepo.deleteById(1L);
            return true;
        }
        return false;
    }


    @Override
    public boolean update(Calculation calc) {
        if (calculationRepo.existsById(1L)) {
            Calculation tempCalc = calculationRepo.findById(1L).orElse(null);
            if (tempCalc == null) {
                return false;
            }
            tempCalc = calc;
            tempCalc.setId(1L);
            calculationRepo.save(tempCalc);
            return true;
        }
        return false;
    }
}
