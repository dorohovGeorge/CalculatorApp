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
    private Long firstNumber;
    @Column(name = "secondNumber")
    private Long secondNumber;
    @Column(name = "result")
    private Long result;

    private String action;

    public Calculation(Long id, Long firstNumber, Long secondNumber, String action) {
        this.id = id;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.action = action;
    }

    public Calculation(Long firstNumber, Long secondNumber, String action) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.action = action;
    }

    public Calculation() {
    }

    public Calculation(Long firstNumber, Long secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public Calculation(Long firstNumber, Long secondNumber, Long result) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.result = result;
    }

    public Calculation(Long id, Long firstNumber, Long secondNumber, Long result) {
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

    public Long getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(Long firstNumber) {
        this.firstNumber = firstNumber;
    }

    public Long getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(Long secondNumber) {
        this.secondNumber = secondNumber;
    }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long plus() {
        result = firstNumber + secondNumber;
        return result;
    }

    public Long minus() {
        result =  firstNumber - secondNumber;
        return result;
    }

    public Long multiply() {
        result = firstNumber * secondNumber;
        return result;
    }

    public Long division() {
        result = firstNumber / secondNumber;
        return result;
    }
}
