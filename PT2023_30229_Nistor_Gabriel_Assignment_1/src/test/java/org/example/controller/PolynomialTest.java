package org.example.controller;

import org.junit.jupiter.api.Test;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {

    @Test
    void TestcomplexTest() {
        Polynomial p1 = new Polynomial("2x^4-3x^3-15x^2+32x-12");
        Polynomial p2 = new Polynomial("x^2-4x-12");
        System.out.println(p1.getPolynomial());
        System.out.println(p2.getPolynomial());
        for (Map.Entry<Integer, Monomial> e : p1.getMonomialHashMap().entrySet()) {
            if (e.getValue().getPowerOfX() == 0) {
                assertEquals(-12, e.getValue().getCoefficient());
                assertEquals("-", e.getValue().getSign());
            } else if (e.getValue().getPowerOfX() == 1) {
                assertEquals(32, e.getValue().getCoefficient());
                assertEquals("+", e.getValue().getSign());
            } else if (e.getValue().getPowerOfX() == 2) {
                assertEquals(-15, e.getValue().getCoefficient());
                assertEquals("-", e.getValue().getSign());
            } else if (e.getValue().getPowerOfX() == 3) {
                assertEquals(-3, e.getValue().getCoefficient());
                assertEquals("-", e.getValue().getSign());
            } else if (e.getValue().getPowerOfX() == 4) {
                assertEquals(2, e.getValue().getCoefficient());
                assertEquals("+", e.getValue().getSign());
            } else{
                assertNull(e.getValue());
            }
        }
        for (Map.Entry<Integer, Monomial> e : p2.getMonomialHashMap().entrySet()) {
            if (e.getValue().getPowerOfX() == 0) {
                assertEquals(-12, e.getValue().getCoefficient());
                assertEquals("-", e.getValue().getSign());
            } else  if (e.getValue().getPowerOfX() == 1) {
                assertEquals(-4, e.getValue().getCoefficient());
                assertEquals("-", e.getValue().getSign());
            } else  if (e.getValue().getPowerOfX() == 2) {
                assertEquals(1, e.getValue().getCoefficient());
                assertEquals("+", e.getValue().getSign());
            } else {
                assertNull(e.getValue());
            }
        }
    }

    @Test
    void testConstantPolynomial() {
        Polynomial p = new Polynomial("0.5");
        for (Map.Entry<Integer, Monomial> e : p.getMonomialHashMap().entrySet()) {
            if (e.getValue().getPowerOfX() == 0) {
                assertEquals(0.5, e.getValue().getCoefficient());
                assertEquals("+", e.getValue().getSign());
            } else {
                assertNull(e.getValue());
            }
        }
    }

    @Test
    void testLinearPolynomial() {
        Polynomial p = new Polynomial("3X-0.2");
        for (Map.Entry<Integer, Monomial> e : p.getMonomialHashMap().entrySet()) {
            if (e.getValue().getPowerOfX() == 1) {
                assertEquals(3.0, e.getValue().getCoefficient());
                assertEquals("+", e.getValue().getSign());
            } else if (e.getValue().getPowerOfX() == 0) {
                assertEquals(-0.2, e.getValue().getCoefficient());
                assertEquals("-", e.getValue().getSign());
            } else {
                assertNull(e.getValue());
            }
        }

    }

    @Test
    void testQuadraticPolynomial() {
        Polynomial p = new Polynomial("X^2+4.5X-3");
        for (Map.Entry<Integer, Monomial> e : p.getMonomialHashMap().entrySet()) {
            if (e.getValue().getPowerOfX() == 1) {
                assertEquals(4.5, e.getValue().getCoefficient());
                assertEquals("+", e.getValue().getSign());
            } else if (e.getValue().getPowerOfX() == 2) {
                assertEquals(1.0, e.getValue().getCoefficient());
                assertEquals("+", e.getValue().getSign());
            } else if (e.getValue().getPowerOfX() == 0) {
                assertEquals(-3.0, e.getValue().getCoefficient());
                assertEquals("-", e.getValue().getSign());
            } else {
                assertNull(e.getValue());
            }
        }
    }

    @Test
    void monomial() {
        Polynomial p = new Polynomial("X");
        for (Map.Entry<Integer, Monomial> e : p.getMonomialHashMap().entrySet()) {
            if (e.getValue().getPowerOfX() == 1) {
                assertEquals(1.0, e.getValue().getCoefficient());
                assertEquals("+", e.getValue().getSign());
            } else {
                assertNull(e.getValue());
            }
        }

    }
    @Test
    void simplePolynomial() {
        Polynomial p = new Polynomial("2X+2X^2");
        for (Map.Entry<Integer, Monomial> e : p.getMonomialHashMap().entrySet()) {
            if (e.getValue().getPowerOfX() == 1) {
                assertEquals(2.0, e.getValue().getCoefficient());
                assertEquals("+", e.getValue().getSign());
            } else if (e.getValue().getPowerOfX() == 2) {
                assertEquals(2.0, e.getValue().getCoefficient());
                assertEquals("+", e.getValue().getSign());
            } else {
                assertNull(e.getValue());
            }
        }
    }

    @Test
    void twoTermsPolynomial() {
        Polynomial p = new Polynomial("X+4X^2");
        for (Map.Entry<Integer, Monomial> e : p.getMonomialHashMap().entrySet()) {
            if (e.getValue().getPowerOfX() == 1) {
                assertEquals(1.0, e.getValue().getCoefficient());
                assertEquals("+", e.getValue().getSign());
            } else if (e.getValue().getPowerOfX() == 2) {
                assertEquals(4.0, e.getValue().getCoefficient());
                assertEquals("+", e.getValue().getSign());
            } else {
                assertNull(e.getValue());
            }
        }
    }

    @Test
    void twoTermsPolynomialV2() {
        Polynomial p = new Polynomial("X+X^2");
        for (Map.Entry<Integer, Monomial> e : p.getMonomialHashMap().entrySet()) {
            if (e.getValue().getPowerOfX() == 1) {
                assertEquals(1.0, e.getValue().getCoefficient());
                assertEquals("+", e.getValue().getSign());
            } else if (e.getValue().getPowerOfX() == 2) {
                assertEquals(1.0, e.getValue().getCoefficient());
                assertEquals("+", e.getValue().getSign());
            } else {
                assertNull(e.getValue());
            }
        }
    }
    @Test
    void threeTermsPolynomial() {
        Polynomial p = new Polynomial("X^3-4X^2-5X");
        for(Map.Entry<Integer, Monomial> e : p.getMonomialHashMap().entrySet()) {
            if(e.getValue().getPowerOfX() == 1) {
                assertEquals(-5.0, e.getValue().getCoefficient());
                assertEquals("-", e.getValue().getSign());
            } else if(e.getValue().getPowerOfX() == 2) {
                assertEquals(-4.0, e.getValue().getCoefficient());
                assertEquals("-", e.getValue().getSign());
            } else if(e.getValue().getPowerOfX() == 3) {
                assertEquals(1.0, e.getValue().getCoefficient());
                assertEquals("+", e.getValue().getSign());
            } else {
                assertNull(e.getValue());
            }
        }
    }
    @Test
    void minusBeforeX() {
        Polynomial p = new Polynomial("3+X+3X-X");
        for(Map.Entry<Integer, Monomial> e : p.getMonomialHashMap().entrySet()) {
            if(e.getValue().getPowerOfX() == 1) {
                assertEquals(3.0, e.getValue().getCoefficient());
                assertEquals("+", e.getValue().getSign());
            } else if(e.getValue().getPowerOfX() == 0) {
                assertEquals(3.0, e.getValue().getCoefficient());
                assertEquals("+", e.getValue().getSign());
            } else {
                assertNull(e.getValue());
            }
        }
    }
    @Test
    void constantAndTwoVariablesPolynomial() {
        Polynomial p = new Polynomial("X^3+3+5X");
        for(Map.Entry<Integer, Monomial> e : p.getMonomialHashMap().entrySet()) {
            if(e.getValue().getPowerOfX() == 0) {
                assertEquals(3.0, e.getValue().getCoefficient());
                assertEquals("+", e.getValue().getSign());
            } else if(e.getValue().getPowerOfX() == 1) {
                assertEquals(5.0, e.getValue().getCoefficient());
                assertEquals("+", e.getValue().getSign());
            } else if(e.getValue().getPowerOfX() == 3) {
                assertEquals(1.0, e.getValue().getCoefficient());
                assertEquals("+", e.getValue().getSign());
            } else {
                assertNull(e.getValue());
            }
        }
    }
    @Test
    void twoIdenticalPolynomials() {
        Polynomial p = new Polynomial("X+X");
        for(Map.Entry<Integer, Monomial> e : p.getMonomialHashMap().entrySet()) {
            if(e.getValue().getPowerOfX() != 1) {
                assertNull(e.getValue());
            } else {
                assertEquals(1, e.getValue().getPowerOfX());
                assertEquals( 2.0, e.getValue().getCoefficient());
                assertEquals("+", e.getValue().getSign());
            }
        }
    }
    @Test
    void twoIdenticalPolynomialsWithCoefficients() {
        Polynomial p = new Polynomial("X-2X+4X-6X+X");
        for(Map.Entry<Integer, Monomial> e : p.getMonomialHashMap().entrySet()) {
            if(e.getValue().getPowerOfX() != 1) {
                assertNull(e.getValue());
            } else {
                assertEquals(1, e.getValue().getPowerOfX());
                assertEquals( -2.0, e.getValue().getCoefficient());
                assertEquals("-", e.getValue().getSign());
            }
        }
    }
    @Test
    void nullPolynomial() {
        Polynomial p = new Polynomial("0");

        for(Map.Entry<Integer, Monomial> e : p.getMonomialHashMap().entrySet()) {
            assertNull(e.getValue());
        }
    }
    @Test
    void wrongPolynomial() {
        try {
            Polynomial p = new Polynomial("X^2-X3-X^4^3");
        } catch (IllegalArgumentException e) {
            assertNotNull(e);
        }

    }
}