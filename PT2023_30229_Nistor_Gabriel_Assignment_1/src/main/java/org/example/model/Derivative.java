package org.example.model;

import org.example.controller.Monomial;
import org.example.controller.Polynomial;

import java.util.Map;

public class Derivative extends Operations {
    public Derivative(Polynomial p1) {
        super(p1, null);
    }

    public Polynomial derivative() {
        Polynomial result = new Polynomial();
        for(Map.Entry<Integer, Monomial> e : super.getP1().getMonomialHashMap().entrySet()) {
            Monomial tempRes = e.getValue().derivativeMonomial();
            result.addMonomialHashMap(tempRes);
        }
        return result;
    }
    public Polynomial derivative(Polynomial p1) {
        setP1(p1);
        return derivative();
    }

}
