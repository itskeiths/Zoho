/*Check a string is beautiful (the absoulte difference between adjacent characters in orginal and reversed string are same)*/

import java.util.*;
class AbsoulteDifference{
public static void main(String[] args){
Scanner in = new Scanner(System.in);
System.out.println("Enter the string:");
String str = in.next();
System.out.println(absoulteDiff(str)?"Beautiful":"Not Beautiful");
}

static boolean absoulteDiff(String str){
	int i=0;
	int j=str.length()-1;
	while(i<str.length()-1 && j>0){
		if(Math.abs(str.charAt(i)-str.charAt(i+1))!=Math.abs(str.charAt(j)-str.charAt(j-1))) return false;
		i++;j--;
	}
	return true;
}

}