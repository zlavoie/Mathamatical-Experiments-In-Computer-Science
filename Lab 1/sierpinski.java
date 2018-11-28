//Question2;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class sierpinski extends JPanel{
 Point[] a = new Point[3];
 Point b;
 Point c;
 
 public sierpinski(Point[] p){
  a = p;
  setBounds(0,0,500,500);
 }//end constructor
 
 public void paintComponent(Graphics g){
  super.paintComponents(g);
  setBackground(Color.WHITE);
  Random rnd = new Random();
  
  c = a[rnd.nextInt(3)];
  
  g.setColor(Color.RED);
  for(int i=0; i<1000;i++){
   b = a[rnd.nextInt(3)];
   
   Point mid = new Point(((b.x+c.x)/2),((b.y+c.y)/2));
   c=mid;
   
   g.drawRect(c.x, c.y, 1, 1);//draw rect at Point c
   g.drawRect(b.x, b.y, 1, 1);//draw rect at Point b
  }//end for loop
  
  
 }//end method paintComponent 
 
 public static void main(String [] args){
  JFrame f = new JFrame("Sierpinski"); // get a frame
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     f.setBounds(0,0, 450,450);
  
  Point[] x = new Point[3];//array of three points
  
  x[0] = new Point(210,10);
  x[1] = new Point(10,410);
  x[2] = new Point(410,410);
  
  sierpinski s = new sierpinski(x);

  f.add(s); // add the panel to the frame

  f.setVisible(true);
 }//end main method
 
}//end class sierpinski
