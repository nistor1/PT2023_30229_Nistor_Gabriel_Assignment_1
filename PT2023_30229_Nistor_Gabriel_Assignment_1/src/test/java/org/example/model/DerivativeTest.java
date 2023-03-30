package org.example.model;

import org.example.controller.Monomial;
import org.example.controller.Polynomial;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DerivativeTest {
    @Test
    void derivative() {
        Derivative a = new Derivative(new Polynomial("X+X^2+4X+3"));
        Polynomial p = a.derivative();

        for(Map.Entry<Integer, Monomial> e : p.getMonomialHashMap().entrySet()) {
            if(e.getValue().getPowerOfX() == 1) {
                assertEquals(2, e.getValue().getCoefficient());
            } else if(e.getValue().getPowerOfX() == 0) {
                assertEquals(5, e.getValue().getCoefficient());
            } else {
                assertNull(e.getValue());
            }
        }
    }
}