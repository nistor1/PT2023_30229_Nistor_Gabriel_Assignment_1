package org.example.model;

import org.example.controller.Monomial;
import org.example.controller.Polynomial;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {
    @Test
    void division() {
        Polynomial p1 = new Polynomial("X+X^2+4X");
        Polynomial p2 = new Polynomial("3+X+3X-X");
        Division a = new Division(p1, p2);
        Polynomial[] p = a.divide(p1, p2);

        for(Map.Entry<Integer, Monomial> e : p[0].getMonomialHashMap().entrySet()) {
            if(e.getValue().getPowerOfX() == 0) {
                assertEquals((double)4/3, e.getValue().getCoefficient());
            } else if(e.getValue().getPowerOfX() == 1) {
                assertEquals((double)1/3, e.getValue().getCoefficient());
            } else {
                assertNull(e.getValue());
            }
        }
        for(Map.Entry<Integer, Monomial> e : p[1].getMonomialHashMap().entrySet()) {
            if(e.getValue().getPowerOfX() == 0) {
                assertEquals(-4, e.getValue().getCoefficient());
            } else {
                assertNull(e.getValue());
            }
        }
    }
}