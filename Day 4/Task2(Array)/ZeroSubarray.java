/*Write a Java program to check if a given array contains a sub array with 0 sum*/
import ajva.util.Scanner;
class ZeroSubarray{
public static void main(String[] args){
Scanner in = new Scanner(System.in);
System.out.println("Enter number of elements:");
int n = in.nextInt();
int[] arr = new int[n];
System.out.println("Enter elements of array:");
for(int i=0;i<n;i++) arr[i]=in.nextInt();
for(int i=0;i<n;i++){
int sum=arr[i];
for(int j=i+1;j<n;j++){
sum+=arr[j];
if(sum==0) {
	System.out.println("Subarray with 0 sum found");
	return;
}
}
}
System.out.println("Subarray with zero sum not found");
}
}