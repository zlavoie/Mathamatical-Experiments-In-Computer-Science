import java.util.Scanner;

public class Question8 {
 public static double encode(int e, int m, int text){
  int a = text;
  int b = e;
  int c = m;
  
  double x = 1;
  double y = a;
  while(b > 0){
   if(b%2 == 1){
    x=(x*y)%c;
   }
   y = (y*y)%c; // squaring the base
   b /= 2;
  }
  return (int) x%c;//lines 10-19 from (https://stackoverflow.com/questions/4066952/modular-exponentiation-in-java)
        
  /*System.out.println(e);
  if(e==1){
   return text % m;
  }//base case
  else if(e%2==0){
   return encode(e/2, m, text);
  }//e is even
  else {
   return encode(e-1, m, text);
  }//e is odd
  */
 }//end method encode
 public static void main(String [] args){
  Scanner input = new Scanner(System.in);
     System.out.print("Enter value for e: ");
     int e = input.nextInt();
     System.out.print("Enter value for m: ");
     int m = input.nextInt();
     
     System.out.print("Enter ASCII value to encode: ");
     int text = input.nextInt();
     
     System.out.println("Answer: " + encode(e,m,text));
 }//end main method
}//end class Question8