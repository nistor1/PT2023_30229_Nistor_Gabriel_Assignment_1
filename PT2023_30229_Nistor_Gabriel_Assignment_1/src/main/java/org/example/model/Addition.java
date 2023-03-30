package org.example.model;
import org.example.controller.Polynomial;

public class Addition extends Operations {
    public Addition(Polynomial p1, Polynomial p2) {
       super(p1, p2);
    }

    public Polynomial add() {
        StringBuilder thePolynomial = new StringBuilder();
        thePolynomial.append(appendMonomials(super.getP1()));
        thePolynomial.append(appendMonomials(super.getP2()));
        return new Polynomial(thePolynomial.toString());
    }
    public Polynomial add(Polynomial p1, Polynomial p2) {
        setP1(p1);
        setP2(p2);
        return add();
    }
}
