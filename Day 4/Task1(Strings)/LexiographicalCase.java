/*Write a Java program to compare two strings lexicographical, ignoring case differences*/
import java.util.*;
class LexiographicalCase{
public static void main(String[] args){
Scanner in = new Scanner(System.in);
System.out.println("Enter two Strings:");
String str1 = in.next();
String str2 = in.next();
if(str1.length()!=str2.length()) System.out.println("Lexiographically not equal");
else{
	for(int i=0;i<str1.length();i++){
		if(str1.charAt(i)!=str2.charAt(i) && str1.charAt(i)!=str2.charAt(i)+32 && str1.charAt(i)!=str2.charAt(i)-32) {
			System.out.println("Lexiographically not equal");
			return;
		}
	}
}
System.out.println("Lexiographically Equal");
}
}