//Question5;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Julia extends JPanel{
 Complex C = new Complex(.2, 1);
 double upper_x = 2;
 double upper_y = 2;
 double lower_x = -2;
 double lower_y = -2;
 
 public Julia(){
  
 }//end constructor
 
 public Complex f(Complex z){ 
  Complex result = z.mul(z);
  result = result.add(C);
  
  return result;
 }//end method Complex
 
 public void paintComponent(Graphics g){
  int xPos = 0;
  int yPos = 800;
  
  int max = 2;
  if(C.abs()>2){
   max = (int)(C.getReal() + C.getImaginary());
  }
  else{
   max = 2;
  }
 
   for (double x = lower_x; x < upper_x; x += .005){
    xPos=0;
    for (double y = lower_y; y < upper_y; y += .005){
     Complex send = new Complex(x,y);
     
     int i=0;
     boolean go = true;
    
     int maxi = 50;
     while(i<maxi && go){
      send = f(send);
      if(send.abs()>2){
       go=false;
      }
      
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
  Julia j = new Julia();
  f.add(j);
  
  f.setVisible(true);
  
 }//end main method
 
}//end class Julia