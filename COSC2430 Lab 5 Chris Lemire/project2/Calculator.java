//************************************************
// Calculator.java
//
// Uses the TelephonePanel class to create a (functionless GUI
// like a telephone keypad with a title.
// Illustrates use of BorderLayout and GridLayout.
//************************************************
import javax.swing.*;
public class Calculator {
   public static void main(String[] args) {
      JFrame frame = new JFrame("Simple Calculator");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new CalculatorPanel());
      frame.pack();
      frame.setVisible(true);
   }
}