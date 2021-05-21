package com.example.calculatorapp.model;

import javax.persistence.*;

@Entity
@Table(name="calc")
public class Calculation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstNumber")
    private Double firstNumber;
    @Column(name = "secondNumber")
    private Double secondNumber;
    @Column(name = "result")
    private Double result;

    private String action;

    public Calculation(Long id, Double firstNumber, Double secondNumber, String action) {
        this.id = id;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.action = action;
    }

    public Calculation(Double firstNumber, Double secondNumber, String action) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.action = action;
    }

    public Calculation() {
    }

    public Calculation(Double firstNumber, Double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public Calculation(Double firstNumber, Double secondNumber, Double result) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.result = result;
    }

    public Calculation(Long id, Double firstNumber, Double secondNumber, Double result) {
        this.id = id;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(Double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public Double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(Double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public double plus() {
        result = firstNumber + secondNumber;
        return result;
    }

    public double minus() {
        result =  firstNumber - secondNumber;
        return result;
    }

    public double multiply() {
        result = firstNumber * secondNumber;
        return result;
    }

    public double division() {
        result = firstNumber / secondNumber;
        return result;
    }
}
