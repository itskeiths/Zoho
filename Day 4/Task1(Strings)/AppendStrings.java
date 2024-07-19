/*Write a Java program to read two strings, append them together and return the result. If the strings are different lengths, remove characters from the beginning of the longer string and make them equal length.*/

import java.util.Scanner;
class AppendStrings{
public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	System.out.println("Enter String1: ");
	String str1 = in.next();
	System.out.println("Enter String2: ");
	String str2 = in.next();
	String longerString = str1.length()>str2.length()?str1:str2;
	String shorterString =  str1.length()>str2.length()?str2:str1;
	int difference = longerString.length()-shorterString.length();
	System.out.println(subString(longerString,difference,longerString.length())+shorterString);
	
}

static String subString(String str, int start,int end){
	String result="";
	for(int i=start;i<end;i++) result+=str.charAt(i);
	return result;
}

}
