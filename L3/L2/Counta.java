/*Print the number of a's in within given first N letter in infininte string*/

import java.util.Scanner;
class Counta{
public static void main(String[] args){
Scanner in = new Scanner(System.in);
System.out.println("Enter the String:");
String str = in.next();
System.out.println("Enter N: ");
int N = in.nextInt();
int count=0;
if(N>str.length()) N =str.length();
for(int i=0;i<N;i++){
if(str.charAt(i)=='a') count++;
}
System.out.println("Number of a's :"+count);
}
}