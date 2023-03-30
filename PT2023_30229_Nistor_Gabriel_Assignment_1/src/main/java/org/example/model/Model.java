package org.example.model;

import org.example.controller.Polynomial;

public class Model {
    private Polynomial p1;
    private Polynomial p2;
    private Operations operations;
    public Model() {
    }
    public Model(Polynomial p1, Polynomial p2) {
        operations = new Operations(p1, p2);
        this.p1 = p1;
        this.p2 = p2;
    }
    public Model(String strP1, String strP2) {
        this.p1 = new Polynomial(strP1);
        this.p2 = new Polynomial(strP2);
        operations = new Operations(this.p1, this.p2);
    }

    public String addition() {
        Addition a = (Addition)operations;
        Polynomial p = a.add();
        return p.getPolynomial();
    }

    public String derivative() {
        Derivative a = (Derivative)operations;
        Polynomial p = a.derivative();
        return p.getPolynomial();
    }
    public String division() {
        Division a = (Division)operations;
        Polynomial[] p = a.divide();
        return "Q:" + p[0].getPolynomial() + " R:" + p[1].getPolynomial();
    }
    public String integration() {
        Integration a = (Integration)operations;
        Polynomial p = a.integration();
        return p.getPolynomial() + "+C";
    }
    public String multiplication() {
        Multiplication a = (Multiplication)operations;
        Polynomial p = a.multiply();
        return p.getPolynomial();
    }
    public String subtraction() {
        Subtraction a = (Subtraction)operations;
        Polynomial p = a.subtract();
        return p.getPolynomial();
    }
}
