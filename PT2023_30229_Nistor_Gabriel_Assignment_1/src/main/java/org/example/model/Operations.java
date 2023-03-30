package org.example.model;

import org.example.controller.Monomial;
import org.example.controller.Polynomial;

import java.util.Map;

public class Operations {
    private Polynomial p1;
    private Polynomial p2;

    public Operations (Polynomial p1, Polynomial p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
    public Operations(){
        super();
    }

    public StringBuilder appendMonomials(Polynomial p) {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer, Monomial> m : p.getMonomialHashMap().entrySet()) {
            sb.append(m.getValue().getSign());
            sb.append(Math.abs(m.getValue().getCoefficient()));
            sb.append("X^");
            sb.append(m.getValue().getPowerOfX());
        }
        return sb;
    }
    public StringBuilder appendMinusMonomials(Polynomial p) {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer, Monomial> e : p.getMonomialHashMap().entrySet()) {
            if(e.getValue().getSign().equals("-")) {
                sb.append("+");
            }else {
                sb.append("-");
            }
            sb.append(Math.abs(e.getValue().getCoefficient()));
            sb.append("X^");
            sb.append(e.getValue().getPowerOfX());
        }
        return sb;
    }

    public Polynomial getP1() {
        return p1;
    }

    public Polynomial getP2() {
        return p2;
    }
    public void setP1(Polynomial p1) {
       this.p1 = p1;
    }

    public void setP2(Polynomial p2) {
        this.p2 = p2;
    }
}
