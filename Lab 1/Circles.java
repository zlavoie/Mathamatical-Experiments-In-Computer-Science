import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Circles extends JPanel
{
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    setBackground(Color.WHITE);
    setVisible(true);
    drawCircles(300,200,400,g);
  }
  public void drawCircles(int x, int y, int r, Graphics g)
  {
       g.drawOval(x,y,r,r);
       r/=2;
       if (r > 4)
       {
         drawCircles(x+r+r/2,y+r/2,r,g);
         drawCircles(x-r/2,y+r/2,r,g);
         drawCircles(x+r/2,y-r/2,r,g);
         drawCircles(x+r/2,y+r+r/2,r,g);
       }
  }
 
  public static void main(String [] args)
  {
    JFrame frame = new JFrame("Circles");
    Circles c = new Circles();
    frame.add(c);
    frame.setVisible(true);
    frame.setBounds(0,0,1000,800);
    frame.setResizable(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}
