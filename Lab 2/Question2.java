import java.util.*;


public class Question2 {
 char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
 String ENCODE;
 String CODEWORD;
 
 public Question2(String word, String codeword){
  ENCODE = word;
  CODEWORD = codeword;
 }//end constructor
 
 
 public String chloe(){
  String result = "";
  int codeCount = 0;
  
  char[] charactersIn = new char[ENCODE.length()];
  char[] charactersOut = new char[ENCODE.length()];
  char[] codeWord = new char[CODEWORD.length()];
  int[] codeWordNum = new int[CODEWORD.length()];
  
  //change CODEWORD into char array
  for(int a=0; a<codeWord.length; a++){
   codeWord[a] = CODEWORD.charAt(a);
  }//end for
  
  //change codeWord into int values
  for(int x=0; x<codeWord.length; x++){
   for(int y=0; y<alphabet.length; y++){
    if(codeWord[x]==alphabet[y]){
     codeWordNum[x] = y;//assigns number (0-25) to each letter in the code word
    }
   }//end inner for loop
  }//end outer for loop
  
  
  ENCODE = ENCODE.toLowerCase();//make string lower case
  
  for(int i=0; i<ENCODE.length(); i++){
   charactersIn[i] = ENCODE.charAt(i);
  }//change each character into position in array
  
  for(int x=0; x<charactersIn.length; x++){
   for(int y=0; y<alphabet.length; y++){
    if(charactersIn[x]==alphabet[y]){
     int num = y-codeWordNum[codeCount];
     if(num<0)
      num = 26 + num;
     charactersOut[x] = alphabet[num];
     if(codeCount+1>codeWordNum.length-1)
      codeCount = 0;
     else
      codeCount++;
    }
   }//end inner for loop
  }//end outer for loop
  
  for(int z=0; z<charactersOut.length; z++){
   result += charactersOut[z];
  }//turn charOut array into String
  
  return result;
 }//end method chloe
 
 
 public static void main(String [] args){
  Scanner kb = new Scanner(System.in);
  
  System.out.print("Enter a word to decrypt: ");
  String word = kb.next();

  System.out.print("Enter the codeword: ");
  String codeword = kb.next();
  
  Question2 q = new Question2(word, codeword);
  
  String output = q.chloe();
  
  System.out.println("Decrypted word: " + output);

  kb.close();
 }
 
 
}//end class Question1
