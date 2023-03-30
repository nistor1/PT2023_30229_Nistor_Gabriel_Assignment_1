package org.example.controller;

import org.example.model.*;
import org.example.view.GUI;
import org.example.view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private static final int FIRST_POLYNOMIAL = 0;
    private static final int SECOND_POLYNOMIAL = 1;
    private static final int RESULT_POLYNOMIAL = 2;
    private int writeInP1OrP2 = FIRST_POLYNOMIAL;
    private StringBuilder[] polynomial = new StringBuilder[2];

    private Polynomial p0;
    private Polynomial p1;
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        polynomial[0] = new StringBuilder();
        polynomial[1] = new StringBuilder();
        setCalculatorListeners(view.getView());
    }

    public void setCalculatorListeners(GUI view){

        view.getButton1().addActionListener(this);
        view.getButton2().addActionListener(this);
        view.getButton3().addActionListener(this);
        view.getButton4().addActionListener(this);
        view.getButton5().addActionListener(this);
        view.getButton6().addActionListener(this);
        view.getButton7().addActionListener(this);
        view.getButton8().addActionListener(this);
        view.getButton9().addActionListener(this);
        view.getButton0().addActionListener(this);
        view.getButtonAddition().addActionListener(this);
        view.getButtonSubtraction().addActionListener(this);
        view.getButtonMultiplication().addActionListener(this);
        view.getButtonDivision().addActionListener(this);
        view.getButtonDerivative().addActionListener(this);
        view.getButtonIntegration().addActionListener(this);
        view.getButtonX().addActionListener(this);
        view.getButtonPow().addActionListener(this);
        view.getButtonPlus().addActionListener(this);
        view.getButtonMinus().addActionListener(this);
        view.getButtonDot().addActionListener(this);
        view.getButtonFirstPolynomial().addActionListener(this);
        view.getButtonSecondPolynomial().addActionListener(this);
        view.getClearButton().addActionListener(this);

    }

    private void writePolynomial(ActionEvent e, int index, int textFieldNumber) {
        if (e.getSource() == view.getView().getButton0()) {
            polynomial[index].append("0"); view.getView().setTextField(polynomial[index].toString(), textFieldNumber);
        } else if (e.getSource() == view.getView().getButton1()) {
            polynomial[index].append("1"); view.getView().setTextField(polynomial[index].toString(), textFieldNumber);
        } else if (e.getSource() == view.getView().getButton2()) {
            polynomial[index].append("2"); view.getView().setTextField(polynomial[index].toString(), textFieldNumber);
        } else if (e.getSource() == view.getView().getButton3()) {
            polynomial[index].append("3"); view.getView().setTextField(polynomial[index].toString(), textFieldNumber);
        } else if (e.getSource() == view.getView().getButton4()) {
            polynomial[index].append("4"); view.getView().setTextField(polynomial[index].toString(), textFieldNumber);
        } else if (e.getSource() == view.getView().getButton5()) {
            polynomial[index].append("5"); view.getView().setTextField(polynomial[index].toString(), textFieldNumber);
        } else if (e.getSource() == view.getView().getButton6()) {
            polynomial[index].append("6"); view.getView().setTextField(polynomial[index].toString(), textFieldNumber);
        } else if (e.getSource() == view.getView().getButton7()) {
            polynomial[index].append("7"); view.getView().setTextField(polynomial[index].toString(), textFieldNumber);
        } else if (e.getSource() == view.getView().getButton8()) {
            polynomial[index].append("8"); view.getView().setTextField(polynomial[index].toString(), textFieldNumber);
        } else if (e.getSource() == view.getView().getButton9()) {
            polynomial[index].append("9"); view.getView().setTextField(polynomial[index].toString(), textFieldNumber);
        } else if (e.getSource() == view.getView().getButtonX()) {
            polynomial[index].append("X"); view.getView().setTextField(polynomial[index].toString(), textFieldNumber);
        } else if (e.getSource() == view.getView().getButtonPow()) {
            polynomial[index].append("^"); view.getView().setTextField(polynomial[index].toString(), textFieldNumber);
        } else if (e.getSource() == view.getView().getButtonMinus()) {
            polynomial[index].append("-"); view.getView().setTextField(polynomial[index].toString(), textFieldNumber);
        } else if (e.getSource() == view.getView().getButtonDot()) {
            polynomial[index].append("."); view.getView().setTextField(polynomial[index].toString(), textFieldNumber);
        } else if (e.getSource() == view.getView().getButtonPlus()) {
            polynomial[index].append("+"); view.getView().setTextField(polynomial[index].toString(), textFieldNumber);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.getView().getButtonFirstPolynomial()) {
            writeInP1OrP2 = FIRST_POLYNOMIAL;
        } else if(e.getSource() == view.getView().getButtonSecondPolynomial()) {
            writeInP1OrP2 = SECOND_POLYNOMIAL;
        }
        if(writeInP1OrP2 == FIRST_POLYNOMIAL) {
            writePolynomial(e, FIRST_POLYNOMIAL, 0);
        } else if(writeInP1OrP2 == SECOND_POLYNOMIAL){
            writePolynomial(e, SECOND_POLYNOMIAL, 1);
        }
        if(e.getSource() == view.getView().getClearButton()) {
            view.getView().dispose();
            view = new View(model);

            polynomial[0] = new StringBuilder();
            polynomial[1] = new StringBuilder();
            setCalculatorListeners(view.getView());
        }
        if(e.getSource() == view.getView().getButtonAddition() || e.getSource() == view.getView().getButtonSubtraction() || e.getSource() == view.getView().getButtonMultiplication() ||
                e.getSource() == view.getView().getButtonDivision() || e.getSource() == view.getView().getButtonDerivative() ||e.getSource() == view.getView().getButtonIntegration()) {
            try{
                p0 = new Polynomial(polynomial[0].toString());
                if(e.getSource() != view.getView().getButtonDerivative() && e.getSource() != view.getView().getButtonIntegration()) {
                    p1 = new Polynomial(polynomial[1].toString());
                }
            } catch(IllegalArgumentException exception) {
                view.getView().dispose();
                view = new View(model);
                polynomial[0] = new StringBuilder();
                polynomial[1] = new StringBuilder();
                setCalculatorListeners(view.getView());
                view.getView().newWrongInputPopUp();
            }
            isDerivativeOrIntegration:
            if(e.getSource() == view.getView().getButtonAddition()) {
                view.getView().setTextField(addition(), RESULT_POLYNOMIAL);
            } else if(e.getSource() == view.getView().getButtonSubtraction()) {
                view.getView().setTextField(subtraction(), RESULT_POLYNOMIAL);
            } else if(e.getSource() == view.getView().getButtonMultiplication()) {
                view.getView().setTextField(multiplication(), RESULT_POLYNOMIAL);
            } else if(e.getSource() == view.getView().getButtonDivision()) {
                if(p1.isZero()) {
                    view.getView().newDivisionByZeroPopUp();
                } else {
                    view.getView().setTextField(division(), RESULT_POLYNOMIAL);
                }
            } else if(e.getSource() == view.getView().getButtonDerivative()) {
                view.getView().setTextField(derivative(), RESULT_POLYNOMIAL);
            } else if(e.getSource() == view.getView().getButtonIntegration()) {
                view.getView().setTextField(integration(), RESULT_POLYNOMIAL);
            }
        }
    }


    public String addition() {
        Addition a = new Addition(p0, p1);
        Polynomial p = a.add();
        return p.getPolynomial();
    }

    public String derivative() {
        Derivative a = new Derivative(p0);
        Polynomial p = a.derivative();
        return p.getPolynomial();
    }
    public String division() {
        Division a = new Division(p0, p1);
        Polynomial[] p = a.divide();
        return "Q:" + p[0].getPolynomial() + " R:" + p[1].getPolynomial();
    }
    public String integration() {
        Integration a = new Integration(p0);
        Polynomial p = a.integration();
        return p.getPolynomial() + "+C";
    }
    public String multiplication() {
        Multiplication a = new Multiplication(p0,p1);
        Polynomial p = a.multiply();
        return p.getPolynomial();
    }
    public String subtraction() {
        Subtraction a = new Subtraction(p0, p1);
        Polynomial p = a.subtract();
        return p.getPolynomial();
    }
}
