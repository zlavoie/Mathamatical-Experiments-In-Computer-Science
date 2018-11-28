//package Question3;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Square extends JPanel{
 Point[] p = new Point[8];
 Point xy;
 Point v;
 
 public Square(){
   setBounds(0,0,500,500);}//end constructor
 
 public void paintComponent(Graphics g){
  super.paintComponent(g);
  setBackground(Color.WHITE);
  g.setColor(Color.RED);
  Random rnd = new Random();
  //Hardwire coordinates of four coordinates (#1)
  p[0] = new Point(100,100);
  p[1] = new Point(350,100);
  p[2] = new Point(100,350);
  p[3] = new Point(350,350);
  
  //find midpoints of the squares (#2)
   p[4] = new Point(((p[0].x+p[1].x)/2),((p[0].y+p[1].y)/2));
   p[5] = new Point(((p[1].x+p[2].x)/2),((p[1].y+p[2].y)/2));
   p[6] = new Point(((p[2].x+p[3].x)/2),((p[2].y+p[3].y)/2));
   p[7] = new Point(((p[3].x+p[0].x)/2),((p[3].y+p[0].y)/2));
   
   //Random # generator to find one of 8 points (#3)
   xy = p[rnd.nextInt(8)];  
    
  g.drawRect(p[0].x, p[0].y, 1, 1); //Draw base square
  g.drawRect(p[1].x, p[1].y, 1, 1);
  g.drawRect(p[2].x, p[2].y, 1, 1);
  g.drawRect(p[3].x, p[3].y, 1, 1);
  
  for(int i=0; i<400000; i++){ //FOR LOOP FOR #4-#7

   //select one of four verticies randomly (#4)
   v = p[rnd.nextInt(4)];
   
   //#5
   //draw point p between xy and v such that the distance from p to the vertex is 1/3 the distance from (x,y) to the vertex
   Point pt = new Point(((xy.x+v.x)/3),((xy.y+v.y)/3));
   xy=pt;
   g.drawRect(pt.x, pt.y, 1, 1);

   //call new point xy
  } 
 }
 
 public static void main(String [] args){
  JFrame frame = new JFrame("Square");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setBounds(0,0, 500,500);
     
  Square s = new Square();
  frame.add(s);
  frame.setVisible(true);  
 }//end main method
}//end class Square
