package package1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class color {
   private static final int PREF_W = 800;
   private static final int PREF_H = 600;

   private static void createAndShowGui() {
      Random random = new Random();
      final JPanel panel = new JPanel();

      Color[] colors = {Color.red, Color.orange, Color.yellow, Color.green, Color.blue, Color.cyan};
      panel.setPreferredSize(new Dimension(PREF_W, PREF_H)); // sorry kleopatra
      panel.setLayout(null);

      MyMouseAdapter myMouseAdapter = new MyMouseAdapter();

      for (int i = 0; i < colors.length; i++) {
         Color c = colors[i];
         JLabel label = new JLabel("Label " + (i + 1));
         Border outsideBorder = new LineBorder(Color.black);
         int eb = 10;
         Border insideBorder = new EmptyBorder(eb, eb, eb, eb);
         label.setBorder(BorderFactory.createCompoundBorder(outsideBorder , insideBorder));
         label.setSize(label.getPreferredSize());
         label.setBackground(c);
         label.setOpaque(true);
         int x = random.nextInt(PREF_W - 200) + 100;
         int y = random.nextInt(PREF_H - 200) + 100;
         label.setLocation(x, y);
         label.addMouseListener(myMouseAdapter);
         label.addMouseMotionListener(myMouseAdapter);
         panel.add(label);
      }

      JFrame frame = new JFrame("MovingLabels");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(panel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}

class MyMouseAdapter extends MouseAdapter {

   private Point initialLoc;
   private Point initialLocOnScreen;

   @Override
   public void mousePressed(MouseEvent e) {
      Component comp = (Component)e.getSource();
      initialLoc = comp.getLocation();
      initialLocOnScreen = e.getLocationOnScreen();
   }

   @Override
   public void mouseReleased(MouseEvent e) {
      Component comp = (Component)e.getSource();
      Point locOnScreen = e.getLocationOnScreen();

      int x = locOnScreen.x - initialLocOnScreen.x + initialLoc.x;
      int y = locOnScreen.y - initialLocOnScreen.y + initialLoc.y;
      comp.setLocation(x, y);
   }

   @Override
   public void mouseDragged(MouseEvent e) {
      Component comp = (Component)e.getSource();
      Point locOnScreen = e.getLocationOnScreen();

      int x = locOnScreen.x - initialLocOnScreen.x + initialLoc.x;
      int y = locOnScreen.y - initialLocOnScreen.y + initialLoc.y;
      comp.setLocation(x, y);
   }
}
