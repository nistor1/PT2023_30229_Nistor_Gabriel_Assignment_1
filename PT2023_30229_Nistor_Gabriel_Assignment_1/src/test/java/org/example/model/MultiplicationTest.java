package org.example.model;

import org.example.controller.Monomial;
import org.example.controller.Polynomial;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationTest {
    @Test
    void multiplication() {
        Multiplication a = new Multiplication(new Polynomial("X+X^2+4X"), new Polynomial("3+X+3X-X"));
        Polynomial p = a.multiply();

        for(Map.Entry<Integer, Monomial> e : p.getMonomialHashMap().entrySet()) {
            if(e.getValue().getPowerOfX() == 1) {
                assertEquals(15, e.getValue().getCoefficient());
            } else if(e.getValue().getPowerOfX() == 2) {
                assertEquals(18, e.getValue().getCoefficient());
            } else if(e.getValue().getPowerOfX() == 3) {
                assertEquals(3, e.getValue().getCoefficient());
            } else {
                assertNull(e.getValue());
            }
        }
    }
    @Test
    void subtractionTestV2() {
        Multiplication a = new Multiplication(new Polynomial("2x^4-3x^3-15x^2+32x-12"), new Polynomial("x^2-4x-12"));
        Polynomial p = a.multiply();
        System.out.println(p.getPolynomial());
        for(Map.Entry<Integer, Monomial> e : p.getMonomialHashMap().entrySet()) {
            if(e.getValue().getPowerOfX() == 1) {
                assertEquals(-336, e.getValue().getCoefficient());
            } else if(e.getValue().getPowerOfX() == 2) {
                assertEquals(40, e.getValue().getCoefficient());
            } else if(e.getValue().getPowerOfX() == 3) {
                assertEquals(128, e.getValue().getCoefficient());
            } else if(e.getValue().getPowerOfX() == 4) {
                assertEquals(-27, e.getValue().getCoefficient());
            } else if(e.getValue().getPowerOfX() == 5) {
                assertEquals(-11, e.getValue().getCoefficient());
            } else if(e.getValue().getPowerOfX() == 6) {
                assertEquals(2, e.getValue().getCoefficient());
            } else  if(e.getValue().getPowerOfX() == 0) {
                assertEquals(144, e.getValue().getCoefficient());
            } else {
                assertNull(e.getValue());
            }
        }
    }
}