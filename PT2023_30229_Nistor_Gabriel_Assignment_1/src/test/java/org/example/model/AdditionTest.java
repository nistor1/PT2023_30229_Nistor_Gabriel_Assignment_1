package org.example.model;

import org.example.controller.Monomial;
import org.example.controller.Polynomial;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AdditionTest {

    @Test
    void add() {
        Addition a = new Addition(new Polynomial("X+X^2+4X"), new Polynomial("3+X+3X-X"));
        Polynomial p = a.add();
        for(Map.Entry<Integer, Monomial> e : p.getMonomialHashMap().entrySet()) {
            if(e.getValue().getPowerOfX() == 0) {
                assertEquals(3, e.getValue().getCoefficient());
            } else if(e.getValue().getPowerOfX() == 1) {
                assertEquals(8, e.getValue().getCoefficient());
            } else if(e.getValue().getPowerOfX() == 2) {
                assertEquals(1, e.getValue().getCoefficient());
            } else {
                assertNull(e.getValue());
            }
        }
    }
    @Test
    void addTestV2() {
        Addition a = new Addition(new Polynomial("2x^4-3x^3-15x^2+32x-12"), new Polynomial("x^2-4x-12"));
        Polynomial p = a.add();
        System.out.println(p.getPolynomial());
        for(Map.Entry<Integer, Monomial> e : p.getMonomialHashMap().entrySet()) {
            if(e.getValue().getPowerOfX() == 0) {
                assertEquals(-24, e.getValue().getCoefficient());
            } else if(e.getValue().getPowerOfX() == 1) {
                assertEquals(28, e.getValue().getCoefficient());
            } else if(e.getValue().getPowerOfX() == 2) {
                assertEquals(-14, e.getValue().getCoefficient());
            } else if(e.getValue().getPowerOfX() == 3) {
                assertEquals(-3, e.getValue().getCoefficient());
            } else if(e.getValue().getPowerOfX() == 4) {
                assertEquals(2, e.getValue().getCoefficient());
            } else {
                assertNull(e.getValue());
            }
        }
    }
}