/**********************************************************
 * File name:	Converter.java                          *
 *                                                        *
 * Programming Assignment 2                               *
 * Algorithm: Converts infix to postfix                   *
 * and evaluates postfix.                                 *
 *                                                        *                             
 * Course: COSC2415 Spring 2006                           *
 * Name: Chris Lemire                                     *
 *                                                        *
 * Date: Friday, March 24, 2006                           *
 **********************************************************
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Converter {
  public static void main(String [] args) {
    JFrame frame = new JFrame("Infix to Postfix Converter");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setPreferredSize(new Dimension(900,700));

    frame.getContentPane().add(new ConverterPanel());

    frame.pack();
    frame.setVisible(true);
  }
}

class ConverterPanel extends JPanel 
{
  private JTextField expression;
  private JPanel tp, bp, cp; // top panel, bottom panel, and center panel
  private JLabel name;
  private JButton oneButton, twoButton, threeButton, fourButton, fiveButton;
  private JButton sixButton, sevenButton, eightButton, nineButton, zeroButton;
  private JButton plusButton, minusButton, multButton, divButton, evaluateButton;
  private JButton leftPButton, rightPButton, clearButton, powerButton, convertButton;
  private ButtonListener listener;

  public ConverterPanel()
  {
    name = new JLabel("This program was written by Chris Lemire.");

    expression = new JTextField(65);

    tp = new JPanel();
    bp = new JPanel();
    cp = new JPanel();

    powerButton = new JButton("^");
    sevenButton = new JButton("7");
    eightButton = new JButton("8");
    nineButton = new JButton("9");
    divButton = new JButton("/");
    fourButton = new JButton("4");
    fiveButton = new JButton("5");
    sixButton = new JButton("6");
    multButton = new JButton("*");
    oneButton = new JButton("1");
    twoButton = new JButton("2");
    threeButton = new JButton("3");
    minusButton = new JButton("-");  
    leftPButton = new JButton("(");
    zeroButton = new JButton("0");
    rightPButton = new JButton(")");  
    plusButton = new JButton("+"); 
    evaluateButton = new JButton("Evaluate");
    clearButton = new JButton("Clear");
    convertButton = new JButton("Convert");

    expression.setHorizontalAlignment(JTextField.TRAILING);
    expression.setEditable(false);

    evaluateButton.setBackground(Color.green);
    clearButton.setBackground(Color.green);
    convertButton.setBackground(Color.green);
    evaluateButton.setEnabled(false);

    setLayout(new BorderLayout());
    cp.setLayout(new GridLayout(4,5,4,4));

    tp.add(expression);

    cp.add(powerButton);
    cp.add(sevenButton);
    cp.add(eightButton);
    cp.add(nineButton);
    cp.add(divButton);
    cp.add(leftPButton);
    cp.add(fourButton);
    cp.add(fiveButton);
    cp.add(sixButton);
    cp.add(multButton);
    cp.add(rightPButton);
    cp.add(oneButton);
    cp.add(twoButton);
    cp.add(threeButton);
    cp.add(minusButton);  
    cp.add(clearButton);
    cp.add(evaluateButton);
    cp.add(zeroButton);
    cp.add(convertButton);
    cp.add(plusButton);

    bp.add(name);

    add (tp, BorderLayout.NORTH);
    add (cp, BorderLayout.CENTER);
    add (bp, BorderLayout.SOUTH);

    listener = new ButtonListener();

    oneButton.addActionListener(listener);
    twoButton.addActionListener(listener);
    threeButton.addActionListener(listener);
    fourButton.addActionListener(listener);
    fiveButton.addActionListener(listener);
    sixButton.addActionListener(listener);
    sevenButton.addActionListener(listener);
    eightButton.addActionListener(listener);
    nineButton.addActionListener(listener);
    zeroButton.addActionListener(listener);
    plusButton.addActionListener(listener);
    minusButton.addActionListener(listener);
    multButton.addActionListener(listener);
    divButton.addActionListener(listener);
    powerButton.addActionListener(listener);
    clearButton.addActionListener(listener);
    leftPButton.addActionListener(listener);
    rightPButton.addActionListener(listener);
    convertButton.addActionListener(listener);
    evaluateButton.addActionListener(listener);
  }

  private class ButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      evaluateButton.setEnabled(false);

      // numbers zero through nine
      if (e.getSource() == zeroButton)
        expression.setText(expression.getText() + "0");
      else if (e.getSource() == twoButton)
        expression.setText(expression.getText() + "2");
      else if (e.getSource() == threeButton)
        expression.setText(expression.getText() + "3");
      else if (e.getSource() == fourButton)
        expression.setText(expression.getText() + "4");
      else if (e.getSource() == fiveButton)
        expression.setText(expression.getText() + "5");
      else if (e.getSource() == sixButton)
        expression.setText(expression.getText() + "6");
      else if (e.getSource() == sevenButton)
        expression.setText(expression.getText() + "7");
      else if (e.getSource() == eightButton)
        expression.setText(expression.getText() + "8");
      else if (e.getSource() == nineButton)
        expression.setText(expression.getText() + "9");
      else if (e.getSource() == oneButton)
        expression.setText(expression.getText() + "1");

      // plus, minus, multiply, divide, power
      else if (e.getSource() == plusButton)
        expression.setText(expression.getText() + " + ");
      else if (e.getSource() == minusButton)
        expression.setText(expression.getText() + " - ");
      else if (e.getSource() == multButton)
        expression.setText(expression.getText() + " * ");
      else if (e.getSource() == divButton)
        expression.setText(expression.getText() + " / ");
      else if (e.getSource() == powerButton)
        expression.setText(expression.getText() + " ^ ");

      // clear, left parathesis, right parathesis, 
      else if (e.getSource() == clearButton) {
        expression.setText("");
        System.out.println();
      }
      else if (e.getSource() == leftPButton)
        expression.setText(expression.getText() + "( ");
      else if (e.getSource() == rightPButton)
        expression.setText(expression.getText() + " )");

      // evaluate and convert
      else if (e.getSource() == convertButton) {
        try {
          evaluateButton.setEnabled(true);
          System.out.println(expression.getText());
          expression.setText(InfixToPostfix.convert(expression.getText()));
          System.out.println(expression.getText());
        }
        catch(Exception exception) {
          System.out.println("Invalid Expression");
        }
      }
      else if (e.getSource() == evaluateButton) {
        try {
          PostfixEvaluator evaluator = new PostfixEvaluator();
          expression.setText(evaluator.evaluate(expression.getText()));
          System.out.println(expression.getText());
        }
        catch(Exception exception) {
          System.out.println("Invalid Expression");
        }
      }
    }
  }   
}  

