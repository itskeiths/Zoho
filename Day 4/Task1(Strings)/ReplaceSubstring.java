/*Write a Java program to replace each substring of a given string that matches the given regular expression with the given replacement*/

import java.util.Scanner;
class ReplaceSubstring{
public static void main(String[] args){
Scanner in = new Scanner(System.in);
System.out.println("Enter a string:");
String str = in.nextLine();
System.out.println("Enter the word to replace:");
String regex = in.next();
System.out.println("Enter the new word:");
String newword =in.next();
int regexLength = regex.length();
String result = "";
int i = 0;

while(i<str.length()){
	if(i+regexLength<str.length() && matches(subString(str,i,i+regexLength),regex)){
		result+=newword;
		i+=regexLength;
	}
	else result+=str.charAt(i++);
}
	System.out.println(result);
}

static boolean matches(String str1, String str2){
	if(str1.length()!=str2.length()) return false;
	for(int i=0;i<str1.length();i++)
	if(str1.charAt(i)!=str2.charAt(i)) return false;
	return true;
}

static String subString(String str, int start,int end){
	String result="";
	for(int i=start;i<end;i++) result+=str.charAt(i);
	return result;
}
}