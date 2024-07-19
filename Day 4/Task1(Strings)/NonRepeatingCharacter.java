/*Write a Java program to find the first non repeating character in a string*/
import java.util.*;
class NonRepeatingCharacter{
public static void main(String[] args){
Scanner in = new Scanner(System.in);
System.out.println("Enter String:");
String str =in.next();
int countchar[] = new int[26];
for(int i=0;i<str.length();i++) countchar[str.charAt(i)-'a']++;
for(int i=0;i<str.length();i++){
if(countchar[str.charAt(i)-'a']==1){
System.out.println("First Non repeating character is "+str.charAt(i));
break;
}
}
}
}
