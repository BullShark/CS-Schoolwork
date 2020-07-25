/**********************************************************
 * File name:       CalculatorPanel.java                  *
 *                                                        *
 * Lab 5 Programming Project 2                            *
 * Purpose: Demonstrates how a Simple Calculator works    *
 *                                                        *
 * Course: COSC2430 Fall 2005                             *
 * Name: Chris Lemire                                     *
 * Date: Nov. 22, 2005                                    *
 **********************************************************
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculatorPanel extends JPanel {

boolean pushed = false; // sets true whenever an operator button is pushed
double left, right; // stores values of numbers being calculated
int i; // represents an operator for the switch statement
JTextField t; // textfield
JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, b_divide, b_multiply, b_minus, b_plus, b_equals, b_point, b_clear; // all buttons
JLabel n; // name
JPanel p, k, b; // panel, keypad, bottom
String l, r, s; // left, right, string, operater

   public CalculatorPanel() {

      // set BorderLayout for this panel and size
      setLayout(new BorderLayout());
      setPreferredSize(new Dimension(700, 700));

      //create a JTextField for the Calculator, sets size and alignment
      t = new JTextField(55);
      t.setHorizontalAlignment(SwingConstants.RIGHT);

      //makes a new panel for text field at top
      p = new JPanel();

      //add text field to the top of the panel
      p.add(t);

      //add title panel to north of this panel
      add (p, BorderLayout.NORTH);

      //create panel to hold keypad and give it a 5x4 GridLayout
      k = new JPanel();
      k.setLayout(new GridLayout(5, 4));

      //creating buttons representing numbers

      b1 = new JButton("1");
      b2 = new JButton("2");
      b3 = new JButton("3");
      b4 = new JButton("4");
      b5 = new JButton("5");
      b6 = new JButton("6");
      b7 = new JButton("7");
      b8 = new JButton("8");
      b9 = new JButton("9");
      b0 = new JButton("0");
      b_divide = new JButton("/");
      b_multiply = new JButton("*");
      b_minus = new JButton("-");
      b_plus = new JButton("+");
      b_equals = new JButton("=");
      b_point = new JButton(".");
      b_clear = new JButton("Clear");

      //adding listeners to buttons

      b1.addActionListener(new B1());
      b2.addActionListener(new B2());
      b3.addActionListener(new B3());
      b4.addActionListener(new B4());
      b5.addActionListener(new B5());
      b6.addActionListener(new B6());
      b7.addActionListener(new B7());
      b8.addActionListener(new B8());
      b9.addActionListener(new B9());
      b0.addActionListener(new B0());
      b_divide.addActionListener(new BDivide());
      b_multiply.addActionListener(new BMultiply());
      b_minus.addActionListener(new BMinus());
      b_plus.addActionListener(new BPlus());
      b_equals.addActionListener(new BEquals());
      b_point.addActionListener(new BPoint());
      b_clear.addActionListener(new BClear());

      //adding buttons to center panel

      k.add (b7);
      k.add (b8);
      k.add (b9);
      k.add (b_divide);
      k.add (b4);
      k.add (b5);
      k.add (b6);
      k.add (b_multiply);
      k.add (b1);
      k.add (b2);
      k.add (b3);
      k.add (b_minus);
      k.add (b_point);
      k.add (b0);
      k.add (b_equals);
      k.add (b_plus);
      k.add (b_clear);

      //add panel to center of this panel
      add (k, BorderLayout.CENTER);

      //added the name label to on keypad
      n = new JLabel("This program was written by Chris Lemire.", SwingConstants.LEFT);

      //panel for bottom
      b = new JPanel();

      //adds name to the bottom panel
      b.add(n);

      //adds bottom panel and puts it at the bottom
      add(b, BorderLayout.SOUTH);
   }


   // --------------------------------------------
   // Button Listener class for b1
   // --------------------------------------------
   private class B1 implements ActionListener {
      public void actionPerformed(ActionEvent event) {
          if(pushed) { // pushed is only true immediately after an operator has been pushed
          t.setText("1");
	  pushed = false; //next number button pressed will execute else statement
	  }
	  else {
          t.setText(t.getText().concat("1"));
	  }
      }
   }


   // --------------------------------------------
   // Button Listener class for b2
   // --------------------------------------------
   private class B2 implements ActionListener {
      public void actionPerformed(ActionEvent event) {
          if(pushed) {
          t.setText("2");
	  pushed = false;
	  }
	  else {
          t.setText(t.getText().concat("2"));
	  }
      }
   }


   // --------------------------------------------
   // Button Listener class for b3
   // --------------------------------------------
   private class B3 implements ActionListener {
      public void actionPerformed(ActionEvent event) {
          if(pushed) {
          t.setText("3");
	  pushed = false;
	  }
	  else {
          t.setText(t.getText().concat("3"));
	  }
      }
   }


   // --------------------------------------------
   // Button Listener class for b4
   // --------------------------------------------
   private class B4 implements ActionListener {
      public void actionPerformed(ActionEvent event) {
          if(pushed) {
          t.setText("4");
	  pushed = false;
	  }
	  else {
          t.setText(t.getText().concat("4"));
	  }
      }
   }


   // --------------------------------------------
   // Button Listener class for b5
   // --------------------------------------------
   private class B5 implements ActionListener {
      public void actionPerformed(ActionEvent event) {
          if(pushed) {
          t.setText("5");
	  pushed = false;
	  }
	  else {
          t.setText(t.getText().concat("5"));
	  }
      }
   }


   // --------------------------------------------
   // Button Listener class for b6
   // --------------------------------------------
   private class B6 implements ActionListener {
      public void actionPerformed(ActionEvent event) {
          if(pushed) {
          t.setText("6");
	  pushed = false;
	  }
	  else {
          t.setText(t.getText().concat("6"));
	  }
      }
   }


   // --------------------------------------------
   // Button Listener class for b7
   // --------------------------------------------
   private class B7 implements ActionListener {
      public void actionPerformed(ActionEvent event) {
          if(pushed) {
          t.setText("7");
	  pushed = false;
	  }
	  else {
          t.setText(t.getText().concat("7"));
	  }
      }
   }


   // --------------------------------------------
   // Button Listener class for b8
   // --------------------------------------------
   private class B8 implements ActionListener {
      public void actionPerformed(ActionEvent event) {
          if(pushed) {
          t.setText("8");
	  pushed = false;
	  }
	  else {
          t.setText(t.getText().concat("8"));
	  }
      }
   }


   // --------------------------------------------
   // Button Listener class for b9
   // --------------------------------------------
   private class B9 implements ActionListener {
      public void actionPerformed(ActionEvent event) {
          if(pushed) {
          t.setText("9");
	  pushed = false;
	  }
	  else {
          t.setText(t.getText().concat("9"));
	  }
      }
   }


   // --------------------------------------------
   // Button Listener class for b0
   // --------------------------------------------
   private class B0 implements ActionListener {
      public void actionPerformed(ActionEvent event) {
          if(pushed) {
          t.setText("0");
	  pushed = false;
	  }
	  else {
          t.setText(t.getText().concat("0"));
	  }
      }
   }


   // --------------------------------------------
   // Button Listener class for b_divide
   // --------------------------------------------
   private class BDivide implements ActionListener {
      public void actionPerformed(ActionEvent event) {
      pushed = true;
      left = Double.parseDouble(t.getText());
      i = 1; // numbers represent operator in switch statement for equals listener
      }
   }


   // --------------------------------------------
   // Button Listener class for b_multiply
   // --------------------------------------------
   private class BMultiply implements ActionListener {
      public void actionPerformed(ActionEvent event) {
      pushed = true;
      left = Double.parseDouble(t.getText());
      i = 2;
      }
   }


   // --------------------------------------------
   // Button Listener class for b_minus
   // --------------------------------------------
   private class BMinus implements ActionListener {
      public void actionPerformed(ActionEvent event) {
      pushed = true;
      left = Double.parseDouble(t.getText());
      i = 3;
      }
   }


   // --------------------------------------------
   // Button Listener class for b_plus
   // --------------------------------------------
   private class BPlus implements ActionListener {
      public void actionPerformed(ActionEvent event) {
      pushed = true;
      left = Double.parseDouble(t.getText());
      i = 4;
      }
   }


   // --------------------------------------------
   // Button Listener class for b_equals
   // --------------------------------------------
   private class BEquals implements ActionListener {
      public void actionPerformed(ActionEvent event) {
      right = Double.parseDouble(t.getText());
         switch(i) {
            case 1:
               left = left / right;
               break;
            case 2:
               left = left * right;
	       break;
            case 3:
               left = left - right;
	       break;
            case 4:
               left = left + right;
	       break;
         }
         t.setText(Double.toString(left));
      }
   }


   // --------------------------------------------
   // Button Listener class for b_point
   // --------------------------------------------
   private class BPoint implements ActionListener {
      public void actionPerformed(ActionEvent event) {
         t.setText(t.getText().concat("."));
      }
   }


   // --------------------------------------------
   // Button Listener class for b_clear
   // --------------------------------------------
   private class BClear implements ActionListener {
      public void actionPerformed(ActionEvent event) {
         t.setText("");
         left = 0;
         right = 0;
      }
   }
}





























































/*
A GUI Simple Calculator

You are to build a simple calculator that performs the basic arithmetic operations (+, -, *, /).  A typical layout is shown 
below.  Modify your lab 1 Telephone panel interface so that it looks similar to the interface below:

Your calculator should be able to continue to calculate the result after user click = button.  For example, if a user wants to 
calculate 3 + 2 + 6, the user will click on 3 + 2 =, the textfield should then display 5.0.  Then the user click + 6 = , and 
the textfield should display 11.0.  The user should be able to continue the calculation in the similar fashion.   

Save your program source code as Calculator.java in the lab5/project2 folder.


Extra Credit (25 pts):
Modify the calculator, so that user can click on 3 + 2 + 6 = to get the result.

Save your program source code as Calculator2.java in the lab5/project2Extra folder.
*/

