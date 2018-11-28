import java.util.*;
public class Permutations
{
  public static int[] encode(int t, int n)
  {
    int m=t-1;
    int[] p=new int[n];
    for (int i=1;i<=n;i++)
    {
      p[i-1]=i;
    }
    for (int i=0;i<m;i++)
    {
      nextPerm(p);
    }
    for (int i=0;i<n;i++)
    {
      System.out.print(p[i]+"");
    }
    System.out.println();
    return p;
  }
  public static int decode(int n,int[] p)
  {
    int [] t=new int[n];
    for(int i=0;i<n;i++)
    {
      t[i]=p[i];
    }
    Arrays.sort(t);
    int count=1;
    while(!equals(t,p,n))
    {
      nextPerm(t);
      count++;
    }
    return count;
  }
  public static boolean equals(int[] t,int[] p, int n)
  {
    for (int i=0;i<n;i++)
    {
      if(t[i]!=p[i])
        return false;
    }
    return true;
  }
  public static void nextPerm(int[] p)
  {
    int n=p.length;
    int k=0;
    int j=0;
    for (int i=0;i<n-1;i++)
    {
      if (p[i]<p[i+1])
      {
        k=i;
      }
    }
    for (int i=k;i<n;i++)
    {
      if (p[k]<p[i])
      {
        j=i;
      }
    }
    int temp=p[k];
    p[k]=p[j];
    p[j]=temp;
    int count=0;
    for(int i=k+1;i<(k+1+n)/2;i++)
    {
      temp=p[i];
      p[i]=p[n-1-count];
      p[n-1-count]=temp;
      count++;
    }
  }
  public static void main(String[] args)
  {
    int[] p=encode(92,5);
    System.out.println(decode(5,p));
  }
}
    