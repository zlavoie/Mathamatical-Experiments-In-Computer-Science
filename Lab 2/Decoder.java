import java.util.Scanner;

public class Decoder {
static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

public static void trySolve(String input){
for(int i=0; i<26; i++){
for(int j= 0; j<26; j++){
  for(int k=0;k<26;k++){
String codeword = alphabet[i]+ "" +alphabet[j]+""+alphabet[k];
System.out.println(codeword);
Question2 q = new Question2(input, codeword);
String output = q.chloe();
System.out.println("Decrypted word: " + output);
}}
}
}
public static void main(String [] args){
Scanner kb = new Scanner(System.in);
System.out.print("Enter word: ");
String input = kb.next();
trySolve(input);
}}