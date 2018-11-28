//package Question1;

import java.util.*;
import java.io.*;

public class RealCompressionDecoded {

 byte[] getBytes = {};
 
 public RealCompressionDecoded(String compFile, String decodedFile){
  compFile = compFile+".txt";
  decodedFile = decodedFile+".txt";
  
  
  //read in compressed file
  File file = new File(compFile);
  try{
   
   //System.out.println(file.length());
   getBytes = new byte[(int) file.length()];
   
   InputStream is = new FileInputStream(file);
         is.read(getBytes);
         is.close();
   
  }//end try
  catch(FileNotFoundException e){
   System.out.println("Error, compressed file not found");
   System.exit(0);
  }//end catch
  catch (IOException e) {
         e.printStackTrace();
     }
  
  //write to decompressed file
  try{
   FileWriter fw = new FileWriter(decodedFile);
   for(int i=0; i<getBytes.length; i++){
    int s = (int)getBytes[i];
    System.out.println((int)getBytes[i]);
    
    
    fw.write(s);
   }
   fw.close();
   
   System.out.println("File " + decodedFile + " decompressed sucessfully.");
  }//end try
  catch(IOException e){
   System.out.println("Error, could not write to decompressed file.");
  }//end catch
  
 }//end constructor
 
 public static void main(String[] args){
  Scanner kb = new Scanner(System.in);
  
  System.out.print("Enter name of compressed file (wihtout .txt extension): ");
  String compFile = kb.next();
  
  System.out.print("Enter the name of decompressed file name(wihtout .txt extension): ");
  String decodedFile = kb.next();
  
  System.out.println("---------Please Wait---------");
  RealCompressionDecoded r = new RealCompressionDecoded(compFile, decodedFile);
  
 }//end main method
 
}//end class RealCompression
