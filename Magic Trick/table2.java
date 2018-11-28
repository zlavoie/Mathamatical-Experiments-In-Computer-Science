//#6
public class table2
{
  int[][] combination;
  int n;
  public table2(int n)
  {
    combination=getCombinations(n);
    this.n=n;
    getCode();
  }
  public int[][] getCombinations(int n)
  {
    int[][] perm =new int[n*(n-1)*(n-2)/6][3];
    int count =0;
    for (int i=1;i<n-1;i++)
    {
      for(int j=i+1;j<n;j++)
      {
        for (int k=j+1;k<n+1;k++)
        {
          perm[count][0]=i;
          perm [count][1]=j;
          perm [count][2]=k;
          count++;
        }
      }
    }
    return perm;
  }
  
  public void getCode()
  {
          int a =0;
    int value=0;
    for(int i=0;i<combination.length;i++)
    {
      for (int j=0;j<3;j++)
      {
        value+=combination[i][j];
      }
      value=value%3;
      int[] perm=new int[2];
      int count=0;
      int left=0;
      for (int j=0;j<3;j++)
      {
        if(j!=value)
        {
          perm[count]=combination[i][j];
          count++;
        }
        else
        {
          left=combination[i][j];
        }
      }
      int value2=(perm[0]+perm[1])%3;
      int [] possible=new int[2];
       int counter=0;
      for (int l=1;l<9;l++)
      {
        if (l<perm[0]&&(l+value2)%3==0)
        {
          possible [counter]=l;
        counter++;}
        else if (l>perm[0]&&l<perm[1]&&(l+value2)%3==1)
        {
          possible[counter]=l;
          counter++;}
        else if(l>perm[1]&&(l+value2)%3==2)
        {
          possible [counter]=l;
        counter++;}
      }
      int p=0;
      for(int k=0;k<2;k++)
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
      //a++;
      //System.out.println(a);
      System.out.println ("Permutation: "+perm[0]+" - "+perm[1]+"   Combination: "+combination[i][0]+"  "+combination[i][1]+"  "+combination[i][2]);          
    }
  }
  public static void main(String[] args)
  {
    table2 t=new table2(8);
  }
}
      