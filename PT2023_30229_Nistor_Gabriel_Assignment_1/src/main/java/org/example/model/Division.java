package org.example.model;

import org.example.controller.Monomial;
import org.example.controller.Polynomial;

public class Division extends Operations {
    public Division(Polynomial dividend, Polynomial divisor) {
        super(dividend, divisor);
    }

    public static Polynomial[] divide(Polynomial dividend, Polynomial divisor) {
        if (dividend == null || divisor == null) {
            throw new NullPointerException("Dividend and divisor must be non-null");
        }

        if (divisor.isZero()) {
            throw new ArithmeticException("Division by zero");
        }

        Polynomial quotient = new Polynomial();
        Polynomial remainder = new Polynomial(dividend.getPolynomial());

        while (!remainder.isZero() && remainder.degree() >= divisor.degree()) {
            int degreeDifference = remainder.degree() - divisor.degree();
            double coefficient = remainder.leadingCoefficient() / divisor.leadingCoefficient();
            int exponent = degreeDifference;

            Polynomial term = new Polynomial(new Monomial(coefficient, exponent).getStringMonomial());
            Multiplication multiplication = new Multiplication(divisor, term);
            Polynomial divisorTerm = multiplication.multiply();

            Addition addition = new Addition(quotient, term);
            quotient = addition.add();
            Subtraction subtraction = new Subtraction(remainder, divisorTerm);
            remainder = subtraction.subtract();
        }
        return new Polynomial[] { quotient, remainder };
    }
    public Polynomial[] divide() {
        return divide(super.getP1(), super.getP2());
    }
}
