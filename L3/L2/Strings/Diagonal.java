/*10.Display the Diagonal pattern for the string of odd length*/

import java.util.Scanner;
class Diagonal{
public static void main(String[] args){
Scanner in = new Scanner(System.in);
System.out.println("Enter a string: ");
String str = in.next();
int n = str.length();
if(n%2==0) {
System.out.println("Not Possible");
return;
}
int left = n/2;
int right = n/2;
int i=0;
int j=0;
while(i<n/2+1){
j=0;
while(j<n){
if(i+j==n/2) System.out.print(str.charAt(left--)+"   ");
else if(j-i==n/2) System.out.print(str.charAt(++right)+"   ");
else System.out.print("    ");
j++;
}
System.out.println();
i++;
}
i=0;
left=1;
right=n-2;
while(i<n/2){
j=0;
while(j<n){
if(j-i==1) System.out.print(str.charAt(left++)+"   ");
else if (i+j==n-2) System.out.print(str.charAt(right--)+"   ");
else System.out.print("    ");
j++;
}
System.out.println();
i++;
}
}
}