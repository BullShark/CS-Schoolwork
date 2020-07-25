import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Multiply3 
{
   public static void main (String [] args)
   {
      JFrame frame = new JFrame("Simple multiply 3");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setPreferredSize(new Dimension(500, 500));
      Multiply3Panel c = new Multiply3Panel();
      frame.getContentPane().add(c);
      frame.pack();
      frame.setVisible(true);
   }
}


class Multiply3Panel extends JPanel
{
   JTextField result = new JTextField(20);
   
   int numResult = 1;

   public Multiply3Panel()
   {
      result.setText(Integer.toString(numResult));      setLayout(new BorderLayout());
      JPanel cp = new JPanel();
      result.setHorizontalAlignment(JTextField.TRAILING);	
      cp.add(result);

      //add title label to north of this panel
      add (cp, BorderLayout.NORTH);

      JPanel subpanel=new JPanel();
      JButton multiply = new JButton("Multiply 3");
      JButton reset = new JButton("Reset");
      subpanel.add(multiply);
      subpanel.add(reset);
     
      add (subpanel, BorderLayout.CENTER);
      multiply.addActionListener(new MultiplyListener());
      reset.addActionListener(new ResetListener());
   }

   private class MultiplyListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         numResult *= 3;
         result.setText(Integer.toString(numResult));
      }
   }

   private class ResetListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         numResult = 1;
         result.setText(Integer.toString(numResult));
      }
   }
}      
