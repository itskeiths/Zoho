class HeapSort{
	public static void main(String[] args){
		int[] arr = {9,14,3,2,43,11,58,22};
		int n = arr.length;
		for(int i=n/2-1;i>=0;i--) heapify(arr,n,i);
		for(int i=n-1;i>=0;i--){
			int temp = arr[i];
			arr[i]=arr[0];
			arr[0] = temp;
			heapify(arr,i,0);
		}
		for(int i=0;i<n;i++) System.out.print(arr[i]+" ");
	}
	
	static void heapify(int[] arr , int n , int i){
		int largest = i;
		int left = 2*i+1, right = 2*i+2;
		if(left<n && arr[largest]<arr[left]) largest = left;
		if(right<n && arr[largest]<arr[right]) largest = right;
		if(largest!=i){
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;
			heapify(arr,n,largest);
		}
	}

}