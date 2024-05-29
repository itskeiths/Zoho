import java.util.*;
class BubbleSort{
public static void main(String[] args){	
	int[] arr = {9,14,3,2,43,11,58,22};
	int n = arr.length;
	for(int i=0;i<n;i++){
	for(int j=i+1;j<n;j++){
	if(arr[j]<arr[i]){
	  int temp = arr[i];
	  arr[i] = arr[j];
	  arr[j] = temp;
	}
	}
	}
	System.out.println("Sorted Array:");
	for(int i=0;i<n;i++){
		System.out.print(arr[i]+" ");
	}
}
}