//package Question1;

import java.util.*;
import java.io.*;

public class RealCompression {

 String inputFileText = "";
 byte[] myByteArray;
 
 public RealCompression(String encodedFile, String compFile){
  encodedFile = encodedFile+".txt";
  compFile = compFile+".txt";
  
  //read in encoded file
  File file = new File(encodedFile);
  try{
   Scanner input = new Scanner(file);
     
   while (input.hasNext())
   {
    inputFileText+=input.next();
   }
  }//end try
  catch(FileNotFoundException e){
   System.out.println("Error, Input file not found");
   System.exit(0);
  }//end catch
  
  int fileSize = inputFileText.length()%8;//if file is not divisible by 8, will add mod 8 places
  
  myByteArray = new byte[(inputFileText.length()+fileSize)/8];//initialize byte array
  
  compressBytes();//call compressor method
  
  //write to output file
  try{
   FileOutputStream fos = new FileOutputStream(compFile);
   fos.write(myByteArray);
   fos.close();
   
   System.out.println("File " + compFile + " encoded sucessfully.");
  }//end try
  catch(IOException e){
   System.out.println("Error, could not write to output file.");
  }//end catch
  
  
  
 }//end constructor
 
 public void compressBytes(){
  byte b;
  int count = 0;
  
  while(inputFileText!=null){
   byte temp = 0;
   for(int i=0; i<8; i++){
    if(inputFileText!=null){
     b = getnext_0_or_1_character();
    }
    
    else{
     //System.out.println("padding");
     b = 0;//padding
    }
    
    //System.out.println("b: " + b);
    //System.out.println("i: "+ (i+1) + " temp: " + temp + " b: " + b);
    temp = (byte)((temp*2) + b);
    
   }
   //System.out.println(temp);
   myByteArray[count] = temp;
   count++;
  }//end while
 }//end method compressBytes
 
 public byte getnext_0_or_1_character(){
 
  byte result; 
  
  if(inputFileText.charAt(0) == '1'){
   result = 1;
  }
  else{
   result = 0;
  }
  
  if(inputFileText.length()>1){
   inputFileText = inputFileText.substring(1, inputFileText.length());
  }
  else {
   //System.out.println("End of file");
   inputFileText = null;
  }
  
  
  return result;
 }//end method getnext_0_or_1_character
 
 public static void main(String[] args){
  Scanner kb = new Scanner(System.in);
  
  System.out.print("Enter name of encoded file (wihtout .txt extension): ");
  String encodedFile = kb.next();
  
  System.out.print("Enter the name of the file you want compressed in bytes (wihtout .txt extension): ");
  String compFile = kb.next();
  
  System.out.println("---------Please Wait---------");
  RealCompression r = new RealCompression(encodedFile, compFile);
  
 }//end main method
 
}//end class RealCompression
