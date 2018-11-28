

import java.util.*;
import java.io.*;

public class HuffmanDecoder {

 String inputFileText = "";
 String outputFileText = "";
 int numEncoded;
 String[] codedChars;
 String[] codeNums;
 
 
 public HuffmanDecoder(String encodedFile, String decodedFile){
  String encodedFileArray = encodedFile + "Array.txt";
  encodedFile = encodedFile + ".txt";
  decodedFile = decodedFile + ".txt";
  
  //Read in encoded file
  File file = new File(encodedFile);
  try{
   Scanner input = new Scanner(file);
   String text = "";
     
   while (input.hasNext())
   {
    text += input.nextLine() + "\n";
    inputFileText+=text;
   }
  }//end try
  catch(FileNotFoundException e){
   System.out.println("File not found");
   System.exit(0);
  }//end catch
  
  //System.out.println("Encoded file text: ");
  //System.out.println(inputFileText);
  
  //Read in code for file
  File file1 = new File(encodedFileArray);
  try{
   Scanner input1 = new Scanner(file1);

   numEncoded = input1.nextInt();
   
   codedChars = new String[numEncoded];
   codeNums = new String[numEncoded];
   
   int i = 0;
   while (i<numEncoded)
   {
    codedChars[i] = input1.next();
    codeNums[i] = input1.next();
    i++;
   }
  }//end try
  catch(FileNotFoundException e){
   System.out.println("File not found");
   System.exit(0);
  }//end catch
  
  /*System.out.println("Decode key: ");
  for(int j=0; j<numEncoded; j++){
   System.out.println(codedChars[j] + " " + codeNums[j]);
  }//print the two arrays*/
  
  decodeFile();//decode the input file
  
  //System.out.println();
  //System.out.println("Decoded text to be writted to file: ");
  //System.out.println(outputFileText);
  //write encoded text to file
  try{
   FileWriter fw = new FileWriter(decodedFile);
   fw.write(outputFileText);
   fw.close();
   System.out.println(decodedFile + " decoded sucessfully.");
  }//end try
  catch(IOException e){
   System.out.println("Error, could not write to output file.");
  }//end catch
  
 }//end default constructor
 
 public void decodeFile(){
  String temp = "";
  for(int i=0; i<inputFileText.length(); i++){
   temp += inputFileText.charAt(i);
   if(compareCode(temp)){
    temp = "";
   }
  }
 }//end method decodeFile
 
 public boolean compareCode(String s){
  boolean equal = false;
  
  for(int i=0; i<codeNums.length; i++){
   if(s.equals(codeNums[i])){
    equal = true;
    outputFileText += codedChars[i];
   }
  }
  
  return equal;
 }//end method compareCode
 
 
 public static void main(String [] args){
  Scanner kb = new Scanner(System.in);
  
  System.out.print("Enter encoded file name (without .txt extention): ");
  String encodedFile = kb.next();
  
  System.out.print("Enter the decoded file name (without .txt extention): ");
  String decodedFile = kb.next();
  
  System.out.println("---------Please Wait---------");
  HuffmanDecoder h = new HuffmanDecoder(encodedFile, decodedFile);
  
 }//end main method
}
