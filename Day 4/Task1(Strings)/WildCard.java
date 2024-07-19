/*Write a Java program to match two strings where one string contains wildcard characters.*/

import java.util.Scanner;

class WildCard{
public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	System.out.println("Enter a String: ");
	String str=in.next();
	System.out.println("Enter Pattern: ");
	String pattern=in.next();
	System.out.println(isMatch(str,pattern)?"String and Pattern Matched":"String and Pattern not Matched");
}

static boolean isMatch(String str, String pattern){
	if(pattern.length()==0 && str.length()==0) return true;
	if(pattern.length()==0) return false;
	if(str.length()==0){
		for(int i=0;i<pattern.length();i++)
		 	if(pattern.charAt(i)!='*') return false;
	return true;
	}
	if(pattern.charAt(0)==str.charAt(0) || pattern.charAt(0)=='?' || pattern.charAt(0)=='*'){
		if(pattern.charAt(0)=='*'){
			return isMatch(str,pattern.substring(1)) || isMatch(str.substring(1),pattern);
		}
		else return isMatch(str.substring(1),pattern.substring(1));
	}
	return false;
}
}