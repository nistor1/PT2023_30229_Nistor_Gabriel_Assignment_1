package org.example.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonomialTest {
    @Test
    void noVariable() {
        Monomial m = new Monomial("");
        assertEquals(m.getCoefficient(), 0);
        assertEquals(m.getPowerOfX(), 0);
        assertEquals("+", m.getSign());
    }
    @Test
    void justCoefficient() {
        Monomial m = new Monomial("4");
        assertEquals(m.getCoefficient(), 4);
        assertEquals(m.getPowerOfX(), 0);
        assertEquals("+", m.getSign());
    }
    @Test
    void noCoefficient() {
        Monomial m = new Monomial("X");
        assertEquals(m.getCoefficient(), 1);
        assertEquals("+", m.getSign());
    }
    @Test
    void negativeCoefficient() {
        Monomial m = new Monomial("-4X");
        assertEquals(m.getCoefficient(), -4);
        assertEquals("-", m.getSign());
    }
    @Test
    void signedPositiveCoefficient() {
        Monomial m = new Monomial("+4X");
        assertEquals(m.getCoefficient(), 4);
        assertEquals("+", m.getSign());
    }
    @Test
    void positiveCoefficient() {
        Monomial m = new Monomial("4X");
        assertEquals(m.getCoefficient(), 4);
        assertEquals("+", m.getSign());
    }
    @Test
    void negativeCoefficientAndPower() {
        Monomial m = new Monomial("-4X^2");
        assertEquals(m.getPowerOfX(), 2);
        assertEquals("-", m.getSign());
    }
    @Test
    void positiveCoefficientAndPower() {
        Monomial m = new Monomial("+4X^2");
        assertEquals(m.getPowerOfX(), 2);
        assertEquals("+", m.getSign());
    }
    @Test
    void noCoefficientAndPower() {
        Monomial m = new Monomial("X^2");
        assertEquals(m.getPowerOfX(), 2);
        assertEquals("+", m.getSign());
    }
    @Test
    void noPowerButVariable() {
        Monomial m = new Monomial("X");
        assertEquals(m.getPowerOfX(), 1);
        assertEquals("+", m.getSign());
    }
}