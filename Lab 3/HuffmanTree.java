//package Question1;

import java.util.*;
import java.io.*;

public class HuffmanTree
{
 
 HuffmanQueue hq = new HuffmanQueue();
 HuffmanQueue hqNew;
 Node root;
 String inputFileText = "";
 String outputFileText = "";
 String outputFile;
 String codeword;
 String[] frequencyCode = new String[128];
 String frequencyCodeText = "";
 int frequencyCodeCount = 0;

 public HuffmanTree(String inputFile, String outputFile) {
     inputFile = inputFile+".txt";
     String outputArray = outputFile +"Array.txt";
     outputFile = outputFile+".txt";
  File file = new File(inputFile);
     this.outputFile = outputFile;
     try{
      Scanner input1 = new Scanner(file);
      String text = "";
      String textNoSpaces = "";
     
      while (input1.hasNextLine())
      {
       text = input1.nextLine();
       
       textNoSpaces = text.replaceAll(" ","");
       //System.out.println("text input: "+textNoSpaces);
       inputFileText+=textNoSpaces;
      }
      
      //System.out.println();
      //System.out.println("Input file contents: ");
      //System.out.println(inputFileText);//prints text of the input file
   //System.out.println();
      
      int[] freq = getFrequencies(inputFileText);//frequency of all characters in the file
   for (int i = 0; i < freq.length; i++) {
    if(freq[i]>0){
     
     //System.out.println("ht insert: " + freq[i]);
     Node n = new Node((char)i, freq[i],null,null,null);
     //if(((int)n.ch)!=10){//IMPORTANT BUG FIXED: when the int value 10 is passed to char, it is read as a new line
      hq.insert(n);
      //System.out.println("n: "+n.ch +"|");
     //}
      
    }
   }// build HuffmanQueue from frequencies given
         
   //copy data from hq into hq new without keeping any pointers
   hqNew = new HuffmanQueue();
   
   Node tempy = hq.front;
   while(tempy!=null){
    char chNew = tempy.ch;
    int freqNew = tempy.freq;
    
    Node insertNew = new Node();
    insertNew.ch = chNew;
    insertNew.freq = freqNew;
    
    hqNew.insert(insertNew);
    
    tempy = tempy.next;
   }
   
   /*Node tempk = hq.front;
   for(int k=0; k<hq.size; k++){
    System.out.println(tempk.freq + " " + tempk.ch);
    tempk = tempk.next;
   }*/
   
   makeTree();
   
   printEncode();
   //System.out.println("---------Please Wait---------");
   compressFile();
   
   //System.out.println();
   //System.out.println("Output file contents: ");
   //System.out.println(outputFileText);
   
   //System.out.println();
   //System.out.println("Frequency contents in array (position : code): ");
   for(int f=0; f<frequencyCode.length; f++){
    if((frequencyCode[f]!=null) && (!frequencyCode[f].equals(""))){
     frequencyCodeCount++;
     frequencyCodeText += ((char)f) + " " + frequencyCode[f] + "\n";
     //System.out.println("===" + ((char)f) + " : " + frequencyCode[f] + " / ");//only print if char value is assigned a code
    }
   }//print the frequency array
   //System.out.println("Number of encoded characters: " + frequencyCodeCount);
   //write encoded text to file
   try{
    FileWriter fw = new FileWriter(outputFile);
    fw.write(outputFileText);
    fw.close();
    System.out.println(outputFile + " encoded sucessfully");
   }//end try
   catch(IOException e){
    System.out.println("Error, could not write to output file.");
   }//end catch
   
   //write array to file
   try{
    FileWriter fw = new FileWriter(outputArray);
    fw.write(frequencyCodeCount + "\n");
    fw.write(frequencyCodeText);
    fw.close();
   }//end try
   catch(IOException e){
    System.out.println("Error, could not write to output file.");
   }//end catch
   
   
     }//end try
     catch(FileNotFoundException e){
      System.out.println("Error, input file not found.");
      System.exit(0);
     }//end catch
 }//end constructor
 
 public int[] getFrequencies(String s){
  int[] freq = new int[128];
     
  for (int i = 0; i < s.length(); i++)
     {
       freq[(int)s.charAt(i)]++; 
     }
  
  /*for(int x=0; x<freq.length;x++){
   if(freq[x]>0)System.out.print((char)x+ ": " + freq[x] + " | ");
  }
  System.out.println();*/
     return freq;
 }//end getFrequencies - returns an array with frequencies of all ASCII characters
 
 public void makeTree(){
  
  
  while(hqNew.returnSize()>1){
   
   
   Node f1 = hqNew.front;
   
   hqNew.remove();
   
   Node f2 = hqNew.front;
   hqNew.remove();
   

   Node temper = new Node('0',(f1.freq + f2.freq));
   
   //System.out.println("temp:"+temp.freq);
   temper.left = f1;
   temper.right = f2;
   
   hqNew.insert(temper);
   
   
  }//end while
  
  root = hqNew.front;//root value stored for encoding
 }//end method makeTree
 
 public void encodeValue(String s, Node treeRoot, char charPassed){
  //System.out.println(charPassed);
  if(treeRoot.ch==charPassed){
   codeword = s;
   //System.out.println(treeRoot.ch + codeword + " /" + ((int)charPassed));
   frequencyCode[((int)charPassed)] = codeword;//save to array
  }
  else{
   if(treeRoot.left!=null)encodeValue(s+0,treeRoot.left,charPassed);
   if(treeRoot.right!=null)encodeValue(s+1,treeRoot.right,charPassed);
  }
 }//end method encodeValue
 
 public void encodeValueFile(String s, Node treeRoot, char charPassed){
  if(treeRoot.ch==charPassed){
   outputFileText = outputFileText + s;
  }
  else{
   if(treeRoot.left!=null)encodeValueFile(s+0,treeRoot.left,charPassed);
   if(treeRoot.right!=null)encodeValueFile(s+1,treeRoot.right,charPassed);
  }
 }//end method encodeValue
 
 public void printEncode(){
  
  Node temp = hq.front;
  
  System.out.println("Character\tFrequency\tCodeword");
  for(int i=0; i<hq.size; i++){
   //System.out.println("--"+temp.ch + " " + temp.freq );
   char character = temp.ch;
   int frequency = temp.freq;
   encodeValue("",root,character);
   System.out.print(character + " \t\t" + frequency + "\t\t" + codeword);
   System.out.println();
   temp = temp.next;
  }
  
 }//end method printEncode
 
 public void compressFile(){
  for(int i=0; i<inputFileText.length(); i++){
   encodeValueFile("",root,inputFileText.charAt(i));
  }//end for loop
 }//end method compressFile
 
 public static void main(String[] args) throws IOException{
     Scanner kb = new Scanner(System.in);
     System.out.print("Input file (wihtout .txt extention): ");
     String inputFile = kb.next();
     System.out.print("Output file (wihtout .txt extention): ");
     String outputFile = kb.next();
     
     System.out.println("---------Please Wait---------");
     HuffmanTree ht = new HuffmanTree(inputFile, outputFile);

 }//end main method
 
}//end class HuffmanTree