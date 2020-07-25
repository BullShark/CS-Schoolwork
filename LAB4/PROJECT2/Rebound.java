/**********************************************************
 * File name:       Circle.java                           *
 *                                                        *
 * Lab 4 Programming Project 1                            *
 * Purpose: Demonstrates a slider to control the speed    *
 *                                                        *
 * Course: COSC2430 Fall 2005                             *
 * Name: Chris Lemire                                     *
 * Date: Nov. 1, 2005                                     *
 **********************************************************
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Rebound
{
   //-----------------------------------------------------------------
   //  Displays the main frame of the program.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      JFrame frame = new JFrame ("Rebound Speed");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(new ReboundPanel());
      frame.pack();
      frame.setVisible(true);
   }
}
