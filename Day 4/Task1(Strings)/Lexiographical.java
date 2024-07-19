/*Write a Java program to compare two strings lexicographical. Two strings are lexicographical equal if they are the same length and contain the same characters in the same positions.*/
import java.util.*;
class Lexiographical{
public static void main(String[] args){
Scanner in = new Scanner(System.in);
System.out.println("Enter two Strings:");
String str1 = in.next();
String str2 = in.next();
if(str1.length()!=str2.length()) System.out.println("Lexiographically not equal");
else{
	for(int i=0;i<str1.length();i++){
		if(str1.charAt(i)!=str2.charAt(i)) {
			System.out.println("Lexiographically not equal");
			return;
		}
	}
}
System.out.println("Lexiographically Equal");
}
}