//Question7;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Mandlebrot extends JPanel
{
  Complex h = new Complex(0,0);
  double upper_x = 2;
  double upper_y = 2;
  double lower_x = -2;
  double lower_y = -2;
 
  public Mandlebrot(){
  
 }//end constructor
 
 public Complex f(Complex z, Complex c)
 { 
   Complex result = z.mul(z);
   result = result.add(c);
  
   return result;
 }//end method Complex
 
 public void paintComponent(Graphics g)
 {
   int xPos = 0;
   int yPos = 800;
 
   
   for (double x = lower_x; x < upper_x; x += .005)
   {
     xPos=0;
     for (double y = lower_y; y < upper_y; y += .005)
     {
       Complex c = new Complex(y,x);
       
       int i=0;
       boolean go = true;
    
       int maxi = 50;
       Complex z = h;
       while(i<maxi && go)
       {
         z = f(z,c);
         if(z.abs()>2)
           go=false;
         i++;
       }//end while
     int count = maxi-i;
     if(count==0){
      g.setColor(Color.BLACK);
     }//prisoner set
     else if(count>0){
      float  red = (count * 24  %   256)/256.0f;  // the f makes 256.0 a float, rather than a double
      float green = (count * 6   %   256)/256.0f;
      float blue = (count * 13   %   256)/256.0f;
      
      Color color = new Color(red, green, blue); // parameters are float
      
      g.setColor(color);
     }//escape set

    g.drawRect(xPos, yPos, 1, 1);
    xPos++;
    }//end inner for
    yPos--;
   }//end outer for
 }
 
 public static void main(String [] args){
  JFrame f = new JFrame();
  f.setBounds(0, 0, 800, 800);
  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  f.setResizable(true);
  Mandlebrot m = new Mandlebrot();
  f.add(m);
  
  f.setVisible(true);
  
 }//end main method
 
}//end class Mandlebrot