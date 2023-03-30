package org.example.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private HashMap<Integer, Monomial> monomialHashMap = new HashMap<>();
    private String polynomial;
    public Polynomial() {
        this.polynomial = "";
    }
    public Polynomial(String polynomial) {
        this.polynomial = polynomial;
        polynomialToMonomials();
        refreshPolynomial();
    }
    private void polynomialToMonomials() throws IllegalArgumentException{
        if(polynomial.charAt(0) != '+' || polynomial.charAt(0) != '-') {
            polynomial = "+" + polynomial;
        }
        String tempPolynomial = polynomial;
        Pattern pattern = Pattern.compile("[+-](\\d*\\.?\\d+|\\d+)?([Xx](?:\\^\\d+)?)?");
        Matcher matcher = pattern.matcher(polynomial);

        while (matcher.find()) {
            String strMonomial = matcher.group();
            if (strMonomial == null || strMonomial.isEmpty()) {
                throw new IllegalArgumentException("Invalid polynomial expression: " + polynomial);
            }

            Monomial monomial = new Monomial(strMonomial);
            addMonomialHashMap(monomial);
        }
        if (0 != tempPolynomial.replaceAll("[+-](\\d*\\.?\\d+|\\d+)?([Xx](?:\\^\\d+)?)?", "").length()) {
            monomialHashMap.clear();
            throw new IllegalArgumentException("Invalid polynomial expression: " + polynomial);
        }
    }

    public void addMonomialHashMap(Monomial monomial) {
        if(monomialHashMap.containsKey(monomial.getPowerOfX())) {
            Monomial temp = monomialHashMap.get(monomial.getPowerOfX());
            monomial.addMonomials(temp);
            if(monomial.getCoefficient() == 0) {
                monomialHashMap.remove(monomial.getPowerOfX());
                return;
            }
        }

        monomialHashMap.put(monomial.getPowerOfX(), monomial);
        refreshPolynomial();
    }

    public void refreshPolynomial(){
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer, Monomial> m : this.getMonomialHashMap().entrySet()) {
            if(m.getValue().getCoefficient() == 0.0) {
                monomialHashMap.remove(m.getValue().getPowerOfX());
            }
            if(!m.getValue().getSign().equals("-")) {
                sb.append(m.getValue().getSign());
            }
            sb.append(String.format("%.2f", m.getValue().getCoefficient()));
            sb.append("X^");
            sb.append(m.getValue().getPowerOfX());
        }
        polynomial = sb.toString();
    }
    public boolean isZero() {
        for(Map.Entry<Integer, Monomial> m : this.getMonomialHashMap().entrySet()) {
            if(m != null) {
                return false;
            }
        }
        return true;
    }
    public int degree() {
        int i = 0;
        for(Map.Entry<Integer, Monomial> m : this.getMonomialHashMap().entrySet()) {
            if(m != null) {
                if(i < m.getValue().getPowerOfX()) {
                    i = m.getValue().getPowerOfX();
                }
            }
        }
        return i;
    }
    public double leadingCoefficient() {
        int i = this.degree();
        return monomialHashMap.get(i).getCoefficient();
    }
    public Monomial getMonomial(Integer key){
        return monomialHashMap.get(key);
    }
    public String getPolynomial() {
        return polynomial;
    }
    public HashMap<Integer, Monomial> getMonomialHashMap() {
        return monomialHashMap;
    }


}
