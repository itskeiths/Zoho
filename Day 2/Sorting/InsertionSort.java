import java.util.*;
class InsertionSort{
public static void main(String[] args){
	int[] arr = {4,10,8,-345,12,45,4,10,10008};
	int n = arr.length;
	int i,j,temp;
	for(i=1;i<n;i++){
	temp = arr[i];
	j = i-1;
	while(j>=0 && temp<=arr[j]){
		arr[j+1]=arr[j];
		j--;
	}	
	arr[j+1]=temp;
	}
	System.out.println("Sorted Array:");
	for(i=0;i<n;i++){
		System.out.print(arr[i]+" ");
	}
		
}
}