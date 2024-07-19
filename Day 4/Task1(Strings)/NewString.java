/*Write a Java program to create a new string from a given string by swapping the last two characters of the given string. The length of the given string must be two or more.*/

import java.util.Scanner;
class NewString{
public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	System.out.println("Enter a string:");
	String str = in.next();
	if(str.length()<2) {
		System.out.println("The string length must be two or more");
		return;
	}
	System.out.println("New String: ");
	System.out.println(subString(str,0,str.length()-2)+str.charAt(str.length()-1)+str.charAt(str.length()-2));
}

static String subString(String str, int start,int end){
	String result="";
	for(int i=start;i<end;i++) result+=str.charAt(i);
	return result;
}

}