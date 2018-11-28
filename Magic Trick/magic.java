import java.util.*;
public class Program7
{
  int[][] combination;
  int n;
  public Program7(int n)
  {
   // combination=getCombinations(n);
    this.n=n;
  }
  public int[][] getCombinations(int n)
  {
    int[][] perm =new int[n*(n-1)*(n-2)/6][5];
    int count =0;
    for (int i=1;i<n-3;i++)
    {
      for(int j=i+1;j<n-2;j++)
      {
        for (int k=j+1;k<n-1;k++)
        {
          for (int l=k+1;l<n;l++)
          {
            for (int o=l+1;o<n+1;o++)
            {
              perm[count][0]=i;
              perm [count][1]=j;
              perm [count][2]=k;
              perm [count][3]=l;
              perm [count][4]=o;
              count++;
            }
          }
        }
      }
    }
    return perm;
  }
  public int[] getCode(int[] hand)
  {
    int value=0;
    for (int j=0;j<5;j++)
    {
      value+=hand[j];
    }
    value=value%5;
    int[] perm=new int[4];
    int count=0;
    int left=0;
    for (int j=0;j<5;j++)
    {
      if(j!=value)
      {
        perm[count]=hand[j];
        count++;
      }
      else
      {
        left=hand[j];
      }
    }
    int value2=(perm[0]+perm[1]+perm[2]+perm[3])%5;
    int [] possible=new int[24];
    int counter=0;
    for (int l=1;l<125;l++)
    {
      if (l<perm[0]&&(l+value2)%5==0)
      {
        possible [counter]=l;
        counter++;}
      else if (l>perm[0]&&l<perm[1]&&(l+value2)%5==1)
      {
        possible[counter]=l;
        counter++;}
      else if(l>perm[1]&&l<perm[2]&&(l+value2)%5==2)
      {
        possible [counter]=l;
        counter++;
      }
      else if(l>perm[2]&&l<perm[3]&&(l+value2)%5==3)
      {
        possible [counter]=l;
        counter++;
      }
      else if(l>perm[3]&&(l+value2)%5==4)
      {
        possible [counter]=l;
        counter++;
      }
    }
    int p=0;
    for(int k=0;k<24;k++)
    {
      if(possible[k]==left)
      {
        p=k;
      }
    }
    for (int j=0;j<p;j++)
    {
      Permutations.nextPerm(perm);
    }
    return perm;      
  }
  public int getCard(int[] hand)
  {
    int[] perm=new int[4];
    int value2=0;
    for (int i=0;i<4;i++)
    {
      perm[i]=hand[i];
      value2+=hand[i];
    }
    Arrays.sort(perm);
    int[] possible=new int[24];
    int counter=0;
    for (int l=1;l<125;l++)
    {
      if (l<perm[0]&&(l+value2)%5==0)
      {
        possible [counter]=l;
        counter++;}
      else if (l>perm[0]&&l<perm[1]&&(l+value2)%5==1)
      {
        possible[counter]=l;
        counter++;}
      else if(l>perm[1]&&l<perm[2]&&(l+value2)%5==2)
      {
        possible [counter]=l;
        counter++;
      }
      else if(l>perm[2]&&l<perm[3]&&(l+value2)%5==3)
      {
        possible [counter]=l;
        counter++;
      }
      else if(l>perm[3]&&(l+value2)%5==4)
      {
        possible [counter]=l;
        counter++;
      }
    }
    int card=possible[getCard(perm,hand)];
    return card;
  }
  public int getCard(int[] perm,int[] hand)
  {
    int count=0;
    while(!areEqual(perm,hand))
    {
      Permutations.nextPerm(perm);
      count++;
    }
    return count;
  }
  public boolean areEqual(int[] perm,int[] hand)
  {
    for (int i=0;i<4;i++)
    {
      if (perm[i]!=hand[i])
      {
        return false;
      }
    }
    return true;
  }   
  public static void main(String[] args)
  {
    Program7 t=new Program7(124);
    int[] hand={23,27,59,87,93};
    //int[] code=t.getCode(hand);
    int[] code={77,66, 55, 44};
    for (int i=0;i<4;i++)
    {
      System.out.print(code[i]+" ");
    }
    System.out.println();
    System.out.println(t.getCard(code)); //change what your sending in for part a and part b (hand or code)
  }
}
      