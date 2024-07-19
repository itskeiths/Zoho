/*Write a Java program to form the largest number from a given list of non negative integers.

Example:

Input :

nums = {1, 2, 3, 0, 4, 6}

Output:

Largest number using the said array numbers: 643210*/

import java.util.Scanner;

class LargeNumber{
public static void main(String[] args){
Scanner in = new Scanner(System.in);
System.out.println("Enter number of elements:");
int n = in.nextInt();
int[] arr = new int[n];
System.out.println("Enter elements of array:");
for(int i=0;i<n;i++) arr[i]=in.nextInt();
int[] freq = new int[10];
StringBuilder sb = new StringBuilder();
for(int i=0;i<n;i++){
	int temp = arr[i];
	if(temp<10) freq[temp]++;
	else{
		while(temp>0){
			int rem = temp%10;
			freq[rem]++;
			temp/=10;
		}
	}
}
for(int i=9;i>=0;i--){
	for(int j=0;j<freq[i];j++){
		sb.append(i);
	}
}
System.out.println("Largest Number formed using the elements of array is: "+sb.toString());
}
}