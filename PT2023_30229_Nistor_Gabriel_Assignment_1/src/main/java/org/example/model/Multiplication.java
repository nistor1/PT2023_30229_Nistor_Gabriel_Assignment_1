package org.example.model;

import org.example.controller.Monomial;
import org.example.controller.Polynomial;

import java.util.Map;

public class Multiplication extends Operations {
    public Multiplication(Polynomial p1, Polynomial p2) {
        super(p1, p2);
    }

    public Polynomial multiply() {
        Polynomial result = new Polynomial();
        for(Map.Entry<Integer, Monomial> e1 : super.getP1().getMonomialHashMap().entrySet()) {
            for(Map.Entry<Integer, Monomial> e2 : super.getP2().getMonomialHashMap().entrySet()) {
                Monomial tempRes = e1.getValue().multiplyMonomials(e2.getValue());
                result.addMonomialHashMap(tempRes);
            }
        }
        return result;
    }
    public Polynomial multiply(Polynomial p1, Polynomial p2) {
        setP1(p1);
        setP2(p2);
        return multiply();
    }
}
