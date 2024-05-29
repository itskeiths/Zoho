/*Find the minimun distance between two equal elements in an array*/

import java.util.Scanner;
class MinDistance{
public static void main(String[] args){
Scanner in = new Scanner(System.in);
System.out.println("Enter the number of elements:");
int n = in.nextInt();
int[] nums = new int[n];
System.out.println("Enter the elements");
for(int i=0;i<n;i++) nums[i]=in.nextInt();
int minDistance = Integer.MAX_VALUE;
int distance = -1;
for(int i=0;i<n;i++){
for(int j=i+1;j<n;j++){
if(nums[i]==nums[j]) distance = j-i; 
}
if(distance<minDistance) minDistance = distance;
}
System.out.println("Minimum Distance: "+minDistance);
}
}