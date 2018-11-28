//recursive implementation of Euclid's algorithm
import java.util.*;

public class Question6a
{
  public int gcd(int a, int b)
  {
    if (b > a)
    {
      int temp = b;
      b = a;
      a = temp;
    }
    if (b == 0)
      return a;
    return gcd(b,a%b);
  }
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter two numbers to find GCD:");
    int a = input.nextInt();
    int b = input.nextInt();
    Question6a obj = new Question6a();
    System.out.println("GCD is " + obj.gcd(a,b));
  }
}