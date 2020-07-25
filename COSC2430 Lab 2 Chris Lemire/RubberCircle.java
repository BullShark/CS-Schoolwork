import javax.swing.JFrame;

public class RubberCircle {
   public static void main(String[] args) {
      JFrame frame = new JFrame("Rubber Circle");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new RubberCirclePanel());
      frame.pack();
      frame.setVisible(true);
   }
}
