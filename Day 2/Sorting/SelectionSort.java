import java.util.*;
class SelectionSort{
public static void main(String[] args){
	int[] arr = {9,14,3,2,43,11,58,22};
	int n = arr.length;
	for(int i=0;i<n-1;i++){
	int min = i;
	for(int j=i+1;j<n;j++){
	if(arr[j]<arr[min]){
	  min = j;
	}
	int temp = arr[i];
	arr[i] = arr[min];
	arr[min] = temp;
	}
	}
	for(int i=0;i<n;i++){
		System.out.print(arr[i]+" ");
	}
	
}
}