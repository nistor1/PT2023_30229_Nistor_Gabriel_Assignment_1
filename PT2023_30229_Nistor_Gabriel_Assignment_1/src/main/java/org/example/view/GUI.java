package org.example.view;

import javax.swing.*;
import java.awt.*;

public class GUI extends View {
    private JButton buttonAddition;
    private JButton buttonSubtraction;
    private JButton buttonMultiplication;
    private JButton buttonDivision;
    private JButton buttonDerivative;
    private JButton buttonIntegration;

    private JButton buttonFirstPolynomial;
    private JButton buttonSecondPolynomial;

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button0;

    private JButton buttonX;
    private JButton buttonPow;

    private JButton buttonPlus;
    private JButton buttonMinus;
    private JButton buttonDot;

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    private JButton clearButton;
    public GUI() {

        this.setTitle("CALCULATOR");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(550,100); //set frame location in the center of the screen
        this.setSize(430, 600);
        this.setLayout(new BorderLayout());

        this.getContentPane().setBackground(Color.getColor("F5F5F5"));

        JPanel panelNorth = createPanelNorth();
        JPanel panelCenter = createPanelCenter();
        JPanel panelSouth = createPanelSouth();

        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);

        this.setVisible(true);
    }
    public JPanel createPanelSouth() {
        //Aceasta metoda suprascrie metoda din clasa parinte, si implementeaza butonul clear
        JPanel clear = new JPanel();
        clear.setLayout(new FlowLayout(FlowLayout.CENTER));
        clearButton = newButton("CLEAR");
        clear.add(clearButton);
        return clear;
    }
    public JPanel createPanelNorth() {

         JLabel logoLabel = new JLabel();
        logoLabel.setText("Polynomial Calculator             ");
        logoLabel.setHorizontalAlignment(JLabel.LEFT);
        logoLabel.setVerticalAlignment(JLabel.NORTH);

       logoLabel.setHorizontalTextPosition(JLabel.CENTER);
        logoLabel.setVerticalTextPosition(JLabel.BOTTOM);
        logoLabel.setFont(new Font("Serif", Font.PLAIN, 30));

        JLabel whiteSpace = new JLabel();
        whiteSpace.setText("_____________________________________________________________________________________________________________");
        whiteSpace.setHorizontalAlignment(JLabel.LEFT);
        whiteSpace.setVerticalAlignment(JLabel.NORTH);

        whiteSpace.setHorizontalTextPosition(JLabel.CENTER);
        whiteSpace.setVerticalTextPosition(JLabel.BOTTOM);
        whiteSpace.setFont(new Font("Serif", Font.PLAIN, 30));

        buttonFirstPolynomial = newButton("Polynomial1");
        buttonSecondPolynomial = newButton("Polynomial2");

        textField1 = new JTextField();
        textField1.setPreferredSize(new Dimension(270, 40));
        textField1.setFont(new Font("Serif", Font.PLAIN, 30));
        textField1.setEditable(false);

        textField2 = new JTextField();
        textField2.setPreferredSize(new Dimension(270, 40));
        textField2.setFont(new Font("Serif", Font.PLAIN, 30));
        textField2.setEditable(false);


        textField3 = new JTextField();
        textField3.setPreferredSize(new Dimension(270, 40));
        textField3.setFont(new Font("Serif", Font.PLAIN, 19));
        textField3.setEditable(false);
        textField3.setText("Result");

        JPanel panel = new JPanel();
        panel.setBackground(Color.getColor("F5F5F5"));
        panel.setPreferredSize(new Dimension(200, 230));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        panel.add(logoLabel);
        panel.add(whiteSpace);
        panel.add(buttonFirstPolynomial);
        panel.add(textField1);
        panel.add(buttonSecondPolynomial);
        panel.add(textField2);
        panel.add(textField3);

        return panel;
    }

    public JPanel createPanelCenter() {

        JPanel panel = new JPanel();
        panel.setBackground(Color.getColor("F5F5F5"));
        panel.setPreferredSize(new Dimension(100, 100));
        panel.setLayout(new GridLayout(7,3, 7, 7));

        buttonAddition = newButton("Addition");
        buttonSubtraction = newButton("Subtraction");
        buttonMultiplication = newButton("Multiplication");
        buttonDivision = newButton("Division");
        buttonDerivative = newButton("Derivative");
        buttonIntegration = newButton("Integration");
        button1 = newButton("1");
        button2 = newButton("2");
        button3 = newButton("3");
        button4 = newButton("4");
        button5 = newButton("5");
        button6 = newButton("6");
        button7 = newButton("7");
        button8 = newButton("8");
        button9 = newButton("9");
        button0 = newButton("0");
        buttonX = newButton("X");
        buttonPow = newButton("^");
        buttonPlus = newButton("+");
        buttonMinus = newButton("-");
        buttonDot = newButton(".");

        //Se creaza panelul cu setarea FlowLayout.center, pentru a dispune butoanele central indiferent de rezolutie
        panel.add(buttonAddition);
        panel.add(buttonSubtraction);
        panel.add(buttonMultiplication);
        panel.add(buttonDivision);
        panel.add(buttonDerivative);
        panel.add(buttonIntegration);
        panel.add(buttonX);
        panel.add(buttonPow);
        panel.add(buttonDot);
        panel.add(button1);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(buttonPlus);
        panel.add(button0);
        panel.add(buttonMinus);

        return panel;
    }
    public void newDivisionByZeroPopUp() {
        JOptionPane.showMessageDialog(null, "UNACCEPTABLE!!!\n DIVIDED BY ZERO (0) !!!\n ZERO\n 0\n THE ANSWER IS INFINITY", "NOT OK", JOptionPane.INFORMATION_MESSAGE);

    }
    public void newWrongInputPopUp() {
        JOptionPane.showMessageDialog(null, "NOT GOOD", "Try again later", JOptionPane.INFORMATION_MESSAGE);

    }

    public JButton newButton(String text) {
        //Functia generica de creare a unui buton.
        JButton button = new JButton(text);
        Font font = button.getFont();
        int newSize = 15;
        button.setFont(font.deriveFont((float) newSize));
        button.setFocusable(false);
        button.setBackground(Color.lightGray);
        button.setBorderPainted(false);
        button.setSize(50,50);

        return button;
    }

    public void setTextField(String str, int textFieldNumber){
        if(textFieldNumber == 0) {
            textField1.setText(str);
        } else if(textFieldNumber == 1) {
            textField2.setText(str);
        } else if(textFieldNumber == 2) {
            textField3.setText(str);
        }
    }

    public JButton getButtonAddition() {
        return buttonAddition;
    }

    public JButton getButtonSubtraction() {
        return buttonSubtraction;
    }

    public JButton getButtonMultiplication() {
        return buttonMultiplication;
    }

    public JButton getButtonDivision() {
        return buttonDivision;
    }

    public JButton getButtonDerivative() {
        return buttonDerivative;
    }

    public JButton getButtonIntegration() {
        return buttonIntegration;
    }

    public JButton getButton1() {
        return button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public JButton getButton3() {
        return button3;
    }

    public JButton getButton4() {
        return button4;
    }

    public JButton getButton5() {
        return button5;
    }

    public JButton getButton6() {
        return button6;
    }

    public JButton getButton7() {
        return button7;
    }

    public JButton getButton8() {
        return button8;
    }

    public JButton getButton9() {
        return button9;
    }

    public JButton getButton0() {
        return button0;
    }

    public JButton getButtonX() {
        return buttonX;
    }

    public JButton getButtonPow() {
        return buttonPow;
    }

    public JButton getButtonPlus() {
        return buttonPlus;
    }

    public JButton getButtonMinus() {
        return buttonMinus;
    }

    public JButton getButtonDot() {
        return buttonDot;
    }
    public JButton getClearButton() {
        return clearButton;
    }

    public JButton getButtonSecondPolynomial() {
        return buttonSecondPolynomial;
    }
    public JButton getButtonFirstPolynomial() {
        return buttonFirstPolynomial;
    }
}
