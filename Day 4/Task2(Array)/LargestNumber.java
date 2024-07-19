/* Write a Java program to form the largest number from a given list of non negative integers.

Example:

Input :

nums = {1, 2, 3, 0, 4, 6}

Output:

Largest number using the said array numbers: 643210*/

class LargestNumber{
public static void main(String[] args){
Scanner in = new Scanner(System.in);
System.out.println("Enter number of elements:");
int n = in.nextInt();
int[] arr = new int[n];
System.out.println("Enter elements of array:");
for(int i=0;i<n;i++) arr[i]=in.nextInt();
int ans = 0;
for(int i=arr.length-2;i>=0;i--){
int temp = arr[i];
int j = i+1;
while(j<arr.length && temp<arr[j]){
	arr[j-1]=arr[j];
	j++;
}
arr[j-1]=temp;
}
for(int i=0;i<arr.length;i++) ans=ans*10+arr[i];
System.out.println("Largest Number formed by array is: "+ans);
}
}