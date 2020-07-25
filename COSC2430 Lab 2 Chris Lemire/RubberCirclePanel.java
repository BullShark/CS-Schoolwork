import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

public class RubberCirclePanel extends JPanel {
   private Point point1 = null, point2 = null;

      public RubberCirclePanel() {
         LineListener listener = new LineListener();
         addMouseListener(listener);
         addMouseMotionListener(listener);

         setBackground(Color.black);
         setPreferredSize(new Dimension(500, 500));
      }

      public void paintComponent(Graphics page) {
         super.paintComponent(page);

         // --------------------------------------------------
         //  Calculates using the distance formula for the circle
         // --------------------------------------------------
         page.setColor(Color.blue);
         if (point1 != null && point2 != null) {
            double distance = Math.sqrt(Math.pow((point1.x - point2.x), 2) + Math.pow((point1.y - point2.y), 2));
            int height = (int) (distance*2);
            int width = (int) (distance*2);
            int num1 = (int) ((double)point1.x - distance);
            int num2 = (int) ((double)point1.y - distance);
            page.drawOval(num1, num2,width, height);
            page.setColor(Color.green);
            page.drawString("This program was written by Chris Lemire.", 5, 15);
          }

         // These two cause exceptions to be thrown, take out to get rid of exceptions
         page.drawString("(" + point2.x + "," + point2.y + ")", 5, 475); 
         page.drawLine (point1.x, point1.y, point2.x, point2.y);
      }

   private class LineListener implements MouseListener, MouseMotionListener {
      public void mousePressed(MouseEvent event) {
         point1 = event.getPoint();
      }

      public void mouseDragged(MouseEvent event) {
         point2 = event.getPoint();
         repaint();
      }

      public void mouseClicked(MouseEvent event) {}
      public void mouseReleased (MouseEvent event) {}
      public void mouseEntered(MouseEvent event) {}
      public void mouseExited(MouseEvent event) {}
      public void mouseMoved(MouseEvent event) {}
   }
}
