package com.example.calculatorapp.service;

import com.example.calculatorapp.model.Calculation;

public interface CalcService {

    void create(Calculation calc);

    Calculation read();

    boolean delete();

    boolean update(Calculation calc);
}
