import java.util.*;
class MaxProduct{
	public static void main(String args[]){
		int[] arr = {1,2,-3,0,-4,-5};
		int n = arr.length;
		int prod1 = arr[0],prod2=arr[0],result=arr[0];
		for(int i=1;i<arr.length;i++){
			int temp = Math.max(arr[i],Math.max(arr[i]*prod1,arr[i]*prod2));
			prod2 = Math.min(arr[i],Math.min(arr[i]*prod1,arr[i]*prod2));
			prod1 = temp;
			result = Math.max(result,temp);
		}
		System.out.println(result);
	}
}