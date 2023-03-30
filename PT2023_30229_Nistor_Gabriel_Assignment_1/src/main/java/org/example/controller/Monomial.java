package org.example.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Monomial {

    private String stringMonomial;
    private Double coefficient = 0.0;
    private String sign = "";
    private Integer power = 0;

    public Monomial(double coefficient, int power) {
        this.coefficient = coefficient;
        this.power = power;
        stringMonomial = coefficient + "X^" + power;
        if(coefficient > 0) {
            sign = "+";
            stringMonomial = sign + stringMonomial;
        } else { sign = "-";
        }
    }

    public Monomial(String monomial) {
        this.stringMonomial = monomial;
        String pattern = "([+-]?)((?:\\d*\\.\\d+|\\d+))?(([a-zA-Z])(?:\\^(\\d+))?)?";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(monomial);

        if (matcher.find()) {
            sign = matcher.group(1);
            if(sign.isEmpty()){
                sign = "+";
            }
            String coefficientStr = matcher.group(2);
            String powerStr = matcher.group(5);
            String varStr = matcher.group(4);
            if (coefficientStr != null && !coefficientStr.isEmpty()) {
                coefficient = Double.parseDouble(coefficientStr);
                if (sign.equals("-")) { coefficient = -coefficient; }
            } else {
                if (varStr != null) {
                    if(coefficientStr == null) { coefficient = 1.0; }
                    if (sign.equals("-")) { coefficient = -coefficient; }
                }
            }
            if (powerStr != null && !powerStr.isEmpty()) {
                power = Integer.parseInt(powerStr);
            } else if(varStr != null) {
                power = 1;
            }
        }
    }
    public void addMonomials(Monomial monomial) {
        this.coefficient += monomial.getCoefficient();
        if(this.coefficient > 0) {
            this.sign = "+";
        } else {
            this.sign = "-";
        }
        stringMonomial = this.coefficient + "X^" + this.getPowerOfX();
    }
    public Monomial multiplyMonomials(Monomial monomial) {
        double coefficient;
        int power;

        coefficient = this.coefficient * monomial.coefficient;
        power = this.power + monomial.power;

        return new Monomial(coefficient, power);
    }
    public Monomial derivativeMonomial() {
        double coefficient;
        int power;

        coefficient = this.coefficient * this.getPowerOfX();
        power = this.power - 1;

        return new Monomial(coefficient, power);
    }
    public Monomial integrateMonomial() {
        double coefficient;
        int power;

        power = this.power + 1;
        coefficient = this.coefficient / power;

        return new Monomial(coefficient, power);
    }
    public Double getCoefficient() {
        return coefficient;
    }

    public String getStringMonomial() {
        return stringMonomial;
    }

    public Integer getPowerOfX() {
        return power;
    }

    public String getSign() {
        return sign;
    }
}