/*Given an array of integers determine the minimum number of elements to delete to leave only one elements of equal value*/

import java.util.Scanner;
class DeleteElements{
public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	System.out.println("Enter the number of elements");
	int n = in.nextInt();
	int[] nums = new int[n];
	System.out.println("Enter the elements of array:");
	for(int i=0;i<n;i++) nums[i]=in.nextInt();
	int count = 0;
	int maxCount = 0;
	for(int i=0;i<n;i++){
		count=0;
		for(int j=0;j<n;j++){
			if(nums[i]==nums[j]) count++;
		}
		if(count>maxCount) maxCount=count;
	}
	System.out.println("Minimum number of elements to delete: "+(n-maxCount));
}
}