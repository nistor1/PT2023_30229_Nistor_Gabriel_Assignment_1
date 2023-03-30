package org.example.model;

import org.example.controller.Monomial;
import org.example.controller.Polynomial;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class IntegrationTest {
    @Test
    void integration() {
        Integration a = new Integration(new Polynomial("X+X^2+4X+3"));
        Polynomial p = a.integration();

        for(Map.Entry<Integer, Monomial> e : p.getMonomialHashMap().entrySet()) {
            if(e.getValue().getPowerOfX() == 1) {
                assertEquals(3, e.getValue().getCoefficient());
            } else if(e.getValue().getPowerOfX() == 2) {
                assertEquals((double)5/2, e.getValue().getCoefficient());
            } else if(e.getValue().getPowerOfX() == 3) {
                assertEquals((double) 1/3, e.getValue().getCoefficient());
            } else {
                assertNull(e.getValue());
            }
        }
    }
}