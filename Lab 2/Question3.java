import java.util.*;

public class Question3 {
 int NUMSHIFTS;
 char[] inputArr;

 
 public Question3(String input){
  NUMSHIFTS = input.length()-1;
  
  //change input into array of chars
  inputArr = new char[input.length()];
  for(int i=0; i<input.length(); i++){
   inputArr[i] = input.charAt(i);
  }
  
  int hits = 0;
  double probab;
  for(int z = 0; z< NUMSHIFTS; z++){
   char[] resultArr = shift(inputArr, z+1);
   
   String results = "";
   for(int c=0; c<resultArr.length; c++){
    results += resultArr[c];
   }//turn charOut array into String
   //System.out.println(results);
   
   
   
   hits = compare(resultArr, inputArr);
    probab = ((hits*100)/inputArr.length);
   System.out.println("Rotation: " + (z+1) + " characters. Hits: " + hits + " Characters in string: " + inputArr.length + " Hits per string: " + hits + "/" + inputArr.length);
   
   System.out.println("Index of coincidence: " + probab + "%");
  }
  
 }//end constructor
 
 public char[] shift(char[] inputArr, int shift){
  char[] result = new char[inputArr.length];
  
  for(int x=0; x<inputArr.length; x++){
   result[x] = inputArr[(x+shift) % inputArr.length];
  }//end outer for loop
  
  return result;
 }//end method shift
 
 public int compare(char[] resultArr, char[] originalArr){
  int hits = 0;
  
  String resAr = "";
  for(int a=0; a<resultArr.length; a++){
   resAr += resultArr[a];
  }
  String orAr = "";
  for(int a=0; a<originalArr.length; a++){
   orAr += originalArr[a];
  }
  //System.out.println();
  System.out.println(resAr + " | " + orAr);
  
  
  for(int x=0; x<resultArr.length; x++){
    if(resultArr[x]==originalArr[x]){
     hits++;
    }
  }//end outer for loop
  
  return hits;
  
 }//end method compare
 
 public static void main(String [] args){
  Scanner kb = new Scanner(System.in);
  
  System.out.print("Enter encrypted text: ");
  String input = kb.next();
  
  Question3 q = new Question3(input);
  
  kb.close();
 }//end main method
 
}//end class Question3
