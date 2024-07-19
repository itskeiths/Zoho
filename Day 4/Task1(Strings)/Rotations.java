/*Write a Java program to check if two given strings are rotations of each other.*/

import java.util.Scanner;
class Rotations{
public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	System.out.println("Enter String 1:");
	String str1 = in.next();
	System.out.println("Enter String 2:");
	String str2 = in.next();
	if(str1.length()!=str2.length()){
		System.out.println("Not rotations");
	}
	String concatenate = str1+str1;
	for(int i=0;i<concatenate.length()-str1.length();i++){
		if(matches(subString(concatenate,i,i+str1.length()),str2)) {
			System.out.println("Rotations for each other");
			return;
		}
	}
	System.out.println("Not rotations");
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