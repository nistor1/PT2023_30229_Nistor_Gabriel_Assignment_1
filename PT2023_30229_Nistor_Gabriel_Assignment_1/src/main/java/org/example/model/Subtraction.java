package org.example.model;

import org.example.controller.Polynomial;
public class Subtraction extends Operations {
    public Subtraction(Polynomial p1, Polynomial p2) {
        super(p1, p2);
    }
    public Polynomial subtract(){
        StringBuilder thePolynomial = new StringBuilder();
        thePolynomial.append(appendMonomials(super.getP1()));
        thePolynomial.append(appendMinusMonomials(super.getP2()));
        return new Polynomial(thePolynomial.toString());
    }
}
