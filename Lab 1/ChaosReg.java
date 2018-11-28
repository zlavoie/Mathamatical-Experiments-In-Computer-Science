import java.awt.*;
import javax.swing.*;
import java.util.*;

public class ChaosReg extends JPanel{
 Point[] a = new Point[3];
 Point v;
 Point w;
 
 public ChaosReg(Point[] p){
  a = p;
  setBounds(0,0,500,500);
  
 }//end constructor
 
 
 public void paintComponent(Graphics g){
  super.paintComponents(g);
  setBackground(Color.WHITE);
  //set background and colors
  
  Random rnd = new  Random();
  w = a[rnd.nextInt(3)];
  g.setColor(Color.RED);
  for(int i=0; i<100000;i++){
   v = a[rnd.nextInt(3)];
   Point mid = new Point(((v.x+w.x)/2),((v.y+w.y)/2));
   w = mid;
   g.drawRect(w.x, w.y, 1,1);
   g.drawRect(v.x, v.y, 1, 1);
  }//draw each triangle
  
  
  
 }//end method paintComponent
 
 public static void main(String[] args) {

     JFrame f = new JFrame("Chaos"); // get a frame
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     f.setBounds(0,0, 450,450);

     Point [] points = new Point[3]; // make an array of three points

     points [0] = new Point ( 210,10);

     points[1] = new Point ( 10,410);

     points [2] = new Point ( 410,410);

     ChaosReg c = new ChaosReg(points);        // the JPanel that you write

     f.add(c); // add the panel to the frame

     f.setVisible(true);

 }//end main method
}
