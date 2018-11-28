import java.util.ArrayList;
import java.util.Scanner;

public class Question9 {

 public static int privateKey(int p, int q, int e, int m){
  int b = (p-1)*(q-1);
  Triple t = Question7.extendedGCD(e,b);
  
  int x = t.y;
  if(x<0){
   x = b+x;
  }//if value is negative, subtract from value for mod
  
  return x;
 }//end method privateKey
 
 public static Coordinates findPrimes(int input){
  ArrayList<Integer> primes = new ArrayList<Integer>();
  int n = input;
  for(int i=2; i<=n; i++){
   while(n%i == 0 ){
    primes.add(i);
    n /= i;
   }
  }
  
  Coordinates c = new Coordinates(primes.get(0),primes.get(1));
  return c;
 }//end method findPrimes
 
 public static void main(String [] args){
  Scanner input = new Scanner(System.in);
  System.out.print("Enter a number to be factored into primes: ");
  
  int number = input.nextInt();
  
  Coordinates results = findPrimes(number);
  
  System.out.println("P: " + results.getX());
     int p = results.getX();
     System.out.println("Q: " + results.getY());
     int q = results.getY();
     
     int m = p*q; 
     System.out.println("M: " + m);
     
     System.out.print("Enter value for e: ");
     int e = input.nextInt();
     
     int a = (p-1)*(q-1);
     while(Question7.gcd(a, e)!=1){
      System.out.print("Error, GCD must equal 1. Enter a different value for e: ");
      e = input.nextInt();
     }
     
     int privateKey = privateKey(p,q,e,m);
     System.out.println();
     System.out.println("Private Key: " + privateKey);
     
     int decryInput = 0;
     System.out.println("--------------------------------------------------------------------");
     while(decryInput!= -1){
      System.out.print("Enter value to be decrypted (or -1 to exit): ");
      decryInput = input.nextInt();
      if(decryInput==-1)System.exit(0);
      
      
      System.out.println("Decrypted value: " + ((int)(Question8.encode(privateKey, m, decryInput))));
      System.out.println("--------------------------------------------------------------------");
     }//end while
 }//end main method
}//end class Question9
