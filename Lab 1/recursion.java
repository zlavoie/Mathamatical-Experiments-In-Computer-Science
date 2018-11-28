//Question1;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class recursion extends JPanel{
 int DEPTH;
 
 public recursion(int depth){
  DEPTH = depth;//sets number of recursions
  
  setVisible(true);
 }//end default constructor
 
 public void paintComponent(Graphics g){
  super.paintComponent(g);
  setBackground(Color.WHITE);
  
  //initialize points
  Point a = new Point(210,10);
  Point b = new Point(10,410);
  Point c = new Point(410,410);
  
  sierpinski(a.x,a.y,b.x,b.y,c.x,c.y, DEPTH, g);
 }//end method paintComponent
 
 public void sierpinski(int x1, int y1, int x2, int y2, int x3, int y3, int depth, Graphics g){
  
  if(depth==0){
   
   g.drawRect(x1, y1, 1, 1);
   
   g.drawRect(x2, y2, 1, 1);
   
   g.drawRect(x3, y3, 1, 1);
  }//base case
  
  else{
   Point Amid = new Point(((x1 + x2)/ 2), ((y1 + y2) / 2));
         Point Bmid = new Point(((x2 + x3) / 2), ((y2 + y3) / 2));
         Point Cmid = new Point(((x3 + x1) / 2), ((y3 + y1) / 2));
         g.setColor(Color.RED); 
         sierpinski(x1, y1, Amid.x, Amid.y, Cmid.x, Cmid.y, depth-1, g);
         g.setColor(Color.GREEN);
         sierpinski(Amid.x, Amid.y, x2, y2, Bmid.x, Bmid.y, depth-1, g);
         g.setColor(Color.BLUE);
         sierpinski(Cmid.x, Cmid.y, Bmid.x, Bmid.y, x3, y3, depth-1, g);
  }//not base case
 }//end method sierpinski
 
 public static void main(String [] args){
  JFrame frame = new JFrame("Recursion Frame");
  recursion r = new recursion(10);//depth is set to 10 when object is initialized
  frame.add(r);
  frame.setVisible(true);
  frame.setBounds(0,0,450,450);
  frame.setResizable(true);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }//end main method

}//end class recursion
