//finds gcd by listing the prime factors for each number, and taking the intersection of the two lists
import java.util.*;

public class Question5
{
   public int[] primeFactors(int n) //finds prime factors of n and stores them in an array
   {
     int[] result = new int[10];
     int pos = 0;
     
     while (n%2==0) //finds all factors of 2
     {
       result[pos] = 2;
       pos++;
       n/=2;
     }
     //n must be odd now
     for (int i = 3; i < Math.sqrt(n); i+=2)
     {
       while (n%i==0) //finds other prime factors (not 2s)
       {
         result[pos] = i;
         pos++;
         n/=i;
       }
     }
     if (n > 2) //checks for final prime factor
     {
       result[pos] = n;
       pos++;
     }
     return result;
   }
   public int[] merge(int[] a, int[] b) //merges common numbers into one array
   {
     int[] result = new int[20];
     int pos = 0;
     
     for (int i = 0; i < a.length; i++)
     {
       for (int j = 0; j < b.length; j++)
       {
         if (a[i] == b[j])
         {
           result[pos] = a[i];
           pos++;
           break;
         }
       }
     }
     return result;
   }
   public int gcd(int a, int b) //mu
   {
     int[] result = merge(primeFactors(a),primeFactors(b));
     int gcd = 1;
     for (int i = 0; i < result.length; i++)
     {
       if (result[i] != 0)
         gcd *= result[i];
     }
     return gcd;
   }
   public static void main(String[] args)
   {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter two numbers to find GCD:");
    int a = input.nextInt();
    int b = input.nextInt();
    Question5 obj = new Question5();
    System.out.println("GCD is " + obj.gcd(a,b));
   }
}


