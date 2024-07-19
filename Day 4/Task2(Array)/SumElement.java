/*Write a Java program to find the sum of the two elements of a given array which is equal to a given integer*/
import java.util.Scanner;
class SumElement{
public static void main(String[] args){
Scanner in = new Scanner(System.in);
System.out.println("Enter number of elements:");
int n = in.nextInt();
int[] arr = new int[n];
System.out.println("Enter elements of array:");
for(int i=0;i<n;i++) arr[i]=in.nextInt();
System.out.println("Enter target:");
int target = in.nextInt();
for(int i=0;i<n;i++){
int sum = 0;
for(int j=i+1;j<n;j++){
	sum=arr[i]+arr[j];
	if(sum==target){
		System.out.println("The target is achieved by adding elements at index " +i+" and " +j);
		return;
	}
}
}
System.out.println("No elements found");
}
}