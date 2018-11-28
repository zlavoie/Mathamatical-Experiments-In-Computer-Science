import java.util.*;

public class Question7 {
	public static int gcd(int a, int b)
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
	  }//end method gcd
	
	public static Triple extendedGCD(int a, int b){
		if(b==0){
			Triple r = new Triple(a, 1, 0);
			return r;
		}//base case
			
		Triple z = extendedGCD(b, a%b);
		int GCD = gcd(a,b);
		int y = z.getZ();
		int x = z.getY();
		
		Triple returnThis = new Triple(GCD, y, x-((a/b)*y));
		return returnThis;
	}//end method findInt
	
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
	    System.out.println("Enter two numbers to find X and Y terms:");
	    int a = input.nextInt();
	    int b = input.nextInt();
	    
	    if(b>a){
	    	int temp = a;
	    	a=b;
	    	b=temp;
	    }
	    
	    System.out.println("X: " + a + " Y: " + b);
	    
	    Triple ans = extendedGCD(a,b);
	    System.out.println("GCD: "+ ans.x + " A: " + ans.y + " B: " + ans.z);
	}//end main method
	
}//end class Question7
