class RadixSort{
	public static void main(String[] args){
		int[] arr = {4,10,8,345,12,45,4,10,10008};
		int n = arr.length;
		int max = arr[0];
		for(int i=1;i<n;i++){
			if(arr[i]>max) max = arr[i];
		}	
		for(int place=1;(max/place)>0;place*=10) countingSort(arr,n,place);
		for(int i=0;i<n;i++) System.out.print(arr[i]+" ");
	}
	
	static void countingSort(int[] a, int n, int place){
		int[] output = new int[n];
		int[] count = new int[10];
		for(int i=0;i<n;i++) count[(a[i]/place)%10]++;
		for(int i=1;i<10;i++) count[i]+=count[i-1];
		for(int i=n-1;i>=0;i--){
			output[count[(a[i]/place)%10]-1]=a[i];
			count[(a[i]/place)%10]--;
		}
		for(int i=0;i<n;i++) a[i]=output[i];
	}
}