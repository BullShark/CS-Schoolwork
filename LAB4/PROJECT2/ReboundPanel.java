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
import javax.swing.event.*; // added for lab4

public class ReboundPanel extends JPanel
{
   private int WIDTH = 300, HEIGHT = 300;
   private int DELAY = 20, IMAGE_SIZE = 35;

   private ImageIcon image;
   private Timer timer;
   private int x, y, moveX, moveY;

   //-----------------------------------------------------------------
   //  ADDED FOR LAB4.
   //-----------------------------------------------------------------
   public JSlider slider;
   public JLabel s, n;
   public JPanel t, l;

   //-----------------------------------------------------------------
   //  Sets up the panel, including the timer for the animation.
   //-----------------------------------------------------------------
   public ReboundPanel()
   {
      //-----------------------------------------------------------------
      //  ADDED FOR LAB4.
      //-----------------------------------------------------------------
      s = new JLabel("Timer Delay");
      n = new JLabel("This program was written by Chris Lemire."); 
      setLayout(new BorderLayout());
      t = new JPanel(); // panel for top
      l = new JPanel(); // lower panel
      slider = new JSlider(0, 250, 125); // sets up slider
      slider.setMajorTickSpacing(50);
      slider.setMinorTickSpacing(10);
      slider.setPaintTicks(true);
      slider.setPaintLabels(true);
      t.add(n); // adds label to top panel
      s.setAlignmentX(Component.LEFT_ALIGNMENT); // aligns label to left near slider
      l.add(s); // adds label to lower panel
      l.add(slider); // adds slider to lower panel
      SliderListener slistener = new SliderListener(); // creates a listener for slider
      slider.addChangeListener(slistener); // adds the listener to slider
      add (t, BorderLayout.NORTH); // adds panels to top and bottom
      add (l, BorderLayout.SOUTH);


      ReboundListener listener = new ReboundListener();
      timer = new Timer(DELAY, listener);

      image = new ImageIcon ("happyFace.gif");

      x = 0;
      y = 40;
      moveX = moveY = 3;

      addMouseListener(listener);
      setPreferredSize (new Dimension(WIDTH, HEIGHT));
      setBackground (Color.black);
      timer.start();
   }

   //-----------------------------------------------------------------
   //  Draws the image in the current location.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {
      super.paintComponent (page);
      image.paintIcon (this, page, x, y);
   }

   //*****************************************************************
   //  Represents the action listener for the timer.
   //*****************************************************************
   private class ReboundListener implements ActionListener, MouseListener
   {
      //--------------------------------------------------------------
      //  Updates the position of the image and possibly the direction
      //  of movement whenever the timer fires an action event.
      //--------------------------------------------------------------
      public void actionPerformed (ActionEvent event)
      {
         int slidePanelHt = l.getSize().height; // assigns variable the height of lower panel

         x += moveX;
         y += moveY;

         // moves face in other direction when it gets to edge of left and right sides of panel
         if (x <= 0 || x >= getSize().width-IMAGE_SIZE)
            moveX = moveX * -1;

         // moves face in other direction when it gets to the top and bottom visible areas of panel
         if (y <= t.getSize().height || y >= getSize().height-slidePanelHt-IMAGE_SIZE)
            moveY = moveY * -1;
    
         repaint();
      }

   //*****************************************************************
   //  What to do when the mouse is clicked.
   //*****************************************************************
   public void mouseClicked (MouseEvent event) {
      if (timer.isRunning())
         timer.stop();
      else
         timer.start();

      repaint();
   }

   //*****************************************************************
   //  Provides empty definition for an unused event method.
   //*****************************************************************
      public void mousePressed (MouseEvent event) {}
      public void mouseReleased (MouseEvent event) {}
      public void mouseEntered (MouseEvent event) {}
      public void mouseExited (MouseEvent event) {}
   }

      //*****************************************************************
      //  Represents the slide listener for the slider. ADDED FOR LAB4.
      //*****************************************************************
      private class SliderListener implements ChangeListener {

      //*****************************************************************
      //  What to do when the slider is moved.
      //  ADDED FOR LAB4.
      //*****************************************************************
      public void stateChanged(ChangeEvent event) {
         timer.setDelay(slider.getValue()); // changes timer to move the face slower or faster
         repaint();
      }
   }
}
