//iterative implementation of Euclid's algorithm
import java.util.*;

public class Question6b
{
  public int gcd(int a, int b)
  {
    if (b > a)
    {
      int temp = b;
      b = a;
      a = temp;
    }
    while (b > 0)
    {
      int c = a % b;
      a = b;
      b = c;
    }
    return a;
  }
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter two numbers to find GCD:");
    int a = input.nextInt();
    int b = input.nextInt();
    Question6b obj = new Question6b();
    System.out.println("GCD is " + obj.gcd(a,b));
  }
}