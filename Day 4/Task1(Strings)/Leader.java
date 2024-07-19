/*Write a Java program to print all the LEADERS in the array.*/
import java.util.Scanner;
class Leader{
public static void main(String[] args){
Scanner in = new Scanner(System.in);
System.out.println("Enter number of elements:");
int n = in.nextInt();
int[] arr = new int[n];
System.out.println("Enter array of elements:");
for(int i=0;i<n;i++) arr[i]=in.nextInt();
System.out.println("Leader numbers are: ");
for(int i=0;i<arr.length-1;i++){
	if(arr[i]>arr[i+1]) System.out.print(arr[i]+" ");
}
}
}