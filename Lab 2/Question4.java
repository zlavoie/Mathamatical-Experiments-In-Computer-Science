//finds the gcd by testing every number, starting at the smaller input

import java.util.*;

public class Question4
{
  public int gcd(int a, int b)
  {
    if (b > a)
    {
      int temp = b;
      b = a;
      a = temp;
    }
    for (int i = b; i > 0; i--)
    {
      if (a % i == 0 && b % i == 0)
         return i;
    }
    return 0;
  }
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter two numbers to find GCD:");
    int a = input.nextInt();
    int b = input.nextInt();
    Question4 obj = new Question4();
    System.out.println("GCD is " + obj.gcd(a,b));
  }
}