package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Monomial {

    private String monomial;
    private Integer coefficient = 0;
    private Integer power = 0;

    public Monomial() {
        System.out.println("1");
    }

    public Monomial(String monomial) {
        String pattern = "^(-?\\d*)?([a-zA-Z])?(\\^(\\d+))?";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(monomial);

        if (matcher.find()) {
            String coeffStr = matcher.group(1);
            String powerStr = matcher.group(4);
            String varStr = matcher.group(2);

            if (coeffStr != null && !coeffStr.isEmpty()) {
                coefficient = Integer.parseInt(coeffStr);
            } else if(varStr != null && coeffStr.isEmpty()) {
                coefficient = 1;
            }
            if (powerStr != null && !powerStr.isEmpty()) {
                power = Integer.parseInt(powerStr);
            } else if(varStr != null) {
                power = 1;
            }
        }

        System.out.println("Coefficient: " + coefficient);
        System.out.println("Power: " + power);
    }

    public Integer getCoefficient() {
        return coefficient;
    }

    public String getMonomial() {
        return monomial;
    }

    public Integer getPowerOfX() {
        return power;
    }
}
