import java.util.*;
class MergeSort{
public static void main(String[] args){
	int[] arr = {9,14,3,2,43,11,58,22};
	mergeSort(arr,0,arr.length-1);
	for(int i=0;i<arr.length;i++){
		System.out.print(arr[i]+" ");
	}
}

static void mergeSort(int[] a , int low, int high){
	if(low<high){
	int mid = (low+high)/2;
	mergeSort(a,low,mid);
	mergeSort(a,mid+1,high);
	merge(a,low,mid,high);
	}
}

static void merge(int[] arr , int low , int mid, int high){
	int n1 = mid-low+1;
	int n2 = high-mid;
	int[] L1 = new int[n1];
	int[] L2 = new int[n2];
	for(int i=0;i<n1;i++) L1[i]= arr[low+i];
	for(int i=0;i<n2;i++) L2[i]= arr[mid+1+i];
	int i =0,j=0,k=low;
	while(i<n1 && j<n2){
		if(L1[i]<L2[j]){
			arr[k++]=L1[i++];
		}
		else arr[k++] = L2[j++];
	}
	while(i<n1){	
		arr[k++] = L1[i++];
	}
	while(j<n2) arr[k++]= L2[j++];
	
}
}