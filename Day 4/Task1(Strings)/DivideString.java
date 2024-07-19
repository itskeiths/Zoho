/*Write a Java program to divide a string into n equal parts.*/

import java.util.Scanner;
class DivideString{
	public static void main(String[] args){
		Scanner in  = new Scanner(System.in);
		System.out.println("Enter a string:");
		String str = in.nextLine();
		System.out.println("Enter the number of parts to divide:");
		int n = in.nextInt();
		if(n>str.length()){
			System.out.println("Enter valid number of parts!");
			return;
		}
		String[] result = new String[n];
		int lengthSubstring = str.length()/n;
		int j = 0;
		for(int i=0;i<n;i++){
			if(i==n-1) result[i]=subString(str,j,str.length());
			else result[i]=subString(str,j,j+lengthSubstring);
			j+=lengthSubstring;
		}
		for(int i=0;i<n;i++) System.out.println("Part "+(i+1)+" = "+ result[i]);
	}
	
	static String subString(String str, int start, int end){
		String result="";
		for(int i=start;i<end;i++) result+=str.charAt(i);
		return result;
	}
}