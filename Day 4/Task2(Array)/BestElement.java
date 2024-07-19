/*Write a Java program to replace every element with the next best element (from right side) in a given array of integers. There is no element next to the last element, therefore replace it with -1.*/
import java.util.Scanner;
class BestElement{
public static void main(String[] args){
Scanner in = new Scanner(System.in);
System.out.println("Enter number of elements:");
int n = in.nextInt();
int[] arr = new int[n];
System.out.println("Enter elements of array:");
for(int i=0;i<n;i++) arr[i]=in.nextInt();
for(int i=0;i<arr.length;i++){
int max=Integer.MIN_VALUE;
for(int j = i+1;j<arr.length;j++){
	if(arr[j]>max) max = arr[j];
}
arr[i]=max;
}
arr[arr.length-1]=-1;
for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
}
}