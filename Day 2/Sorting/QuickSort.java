import java.util.*;
class QuickSort{
public static void main(String[] args){
int arr[] = {9,4,3,2,5,-10,56,23,4,2};
quickSort(arr,0,arr.length-1);
for(int i=0;i<arr.length;i++){
System.out.print(arr[i]+" ");
}
}
static void quickSort(int[] arr,int low, int high){
	if(low<high){
	int p = partition(arr,low,high);
	quickSort(arr,low,p-1);
	quickSort(arr,p+1,high);
	}
}

static int partition(int[] arr , int start,int end){
	int pivot = arr[end];
	int i = start;
	for(int j=start;j<end;j++){
	if(arr[j]<=pivot){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		i++;
	}
	}
	int temp = arr[end];
	arr[end] = arr[i];
	arr[i] = temp;
	return i;
}
}