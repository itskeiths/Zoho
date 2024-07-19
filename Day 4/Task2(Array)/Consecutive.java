/*.Write a Java program to check if a sub-array is formed by consecutive integers from a given array of integers.*/

class Consecutive{
	public static void main(String[] args){
	int[] nums = { 7, 5, 0, 2, 1, 4, 3, 6, 1, 0 };
	int maxLength=0,start=0,end=0;
	for(int i=0;i<nums.length-1;i++){
	for(int j=i+1;j<nums.length;j++){
	int min = findMin(nums,i,j);
	int max = findMax(nums,i,j);
	if(isConsecutive(nums,i,j,max,min)){
		int len = j-i+1;
		if(maxLength<len) {
		maxLength=len;
		start=i;
		end=j;	
		}
	}
	}
	}
	System.out.println("Consecutive Subarray:");
	for(int i=start;i<=end;i++) System.out.print(nums[i]+" ");
}
	static int findMax(int[] arr, int start , int end){
		int max=start;
		for(int i=start+1;i<=end;i++){
			if(arr[max]<arr[i]) max=i;
		}
		return max;
	}

	static int findMin(int[] arr, int start , int end){
		int min=start;
		for(int i=start+1;i<=end;i++){
			if(arr[min]>arr[i]) min=i;
		}
		return min;
	}
	
	static boolean isConsecutive(int[] nums, int start , int end, int max, int min){
		if(nums[max]-nums[min]!=end-start) return false;
		boolean checkDuplicates[] = new boolean[end-start+1];
		for(int i=start;i<=end;i++){
			if(checkDuplicates[nums[i]-nums[min]]) return false;
			checkDuplicates[nums[i]-nums[min]]=true;
		}
		return true;
	}
}