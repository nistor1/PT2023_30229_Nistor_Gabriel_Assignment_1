package org.example;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private HashMap<Integer, Monomial> monomialHashMap = new HashMap<>();
    private String polynomial;

    public Polynomial() {
        System.out.println("Insert polynomial:");
    }

    public Polynomial(String polynomial) {
        this.polynomial = polynomial;
        polynomialToMonomials();
    }

    private void polynomialToMonomials() {
        Integer coefficient = 1;
        String variable = "";

        Pattern pattern = Pattern.compile("[+-]?\\s*(\\d+(\\.\\d+)?|[a-zA-Z]+)(\\^[0-9]+)?");
        Matcher matcher = pattern.matcher(polynomial);

        while(matcher.find()) {
            String strMonomial = matcher.group();
            Monomial monomial = new Monomial(strMonomial);
            monomialHashMap.put(monomial.getCoefficient(), monomial);
        }
    }




}
