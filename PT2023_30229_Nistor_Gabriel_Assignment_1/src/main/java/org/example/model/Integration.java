package org.example.model;

import org.example.controller.Monomial;
import org.example.controller.Polynomial;

import java.util.Map;

public class Integration extends Operations {
    public Integration(Polynomial p1) {
        super(p1, null);
    }

    public Polynomial integration() {
        Polynomial result = new Polynomial();
        for(Map.Entry<Integer, Monomial> e : super.getP1().getMonomialHashMap().entrySet()) {
            Monomial tempRes = e.getValue().integrateMonomial();
            result.addMonomialHashMap(tempRes);
        }
        return result;
    }
    public Polynomial integration(Polynomial p1) {
        setP1(p1);
        return integration();
    }

}
