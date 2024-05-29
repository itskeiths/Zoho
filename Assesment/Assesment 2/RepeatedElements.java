import java.util.*;
class RepeatedElements{
	public static void main(String[] args){
		int[] arr ={2, 3, 2, 3, 16, 3, 15, 16, 15, 15, 16, 2, 3, 6, 2, 3};
		int[] top = new int[4];
		Arrays.fill(top,Integer.MAX_VALUE);
		int idx = 1;
		int maxCount = Integer.MIN_VALUE;
		while(idx<4){
		int i=0;
		int element = 0;
		while(i<arr.length){		
			int count =0;
			int j=i+1;
			while(j<arr.length){
				if(arr[i]==arr[j]) count++;
				j++;
			}
			if(count>maxCount && count<top[idx-1]){
				maxCount = count;
				element=arr[i];
			}
			i++;
		}
		System.out.print(element+" ");
		top[idx++]=element;
		maxCount = Integer.MIN_VALUE;
		}
		
	}
}