package com.example.calculatorapp.repos;

import com.example.calculatorapp.model.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculationRepo extends JpaRepository< Calculation, Long> {
}
