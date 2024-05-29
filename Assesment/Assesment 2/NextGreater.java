class NextGreater{
	public static void main(String[] args){
		int[] arr = {6,3,9,10,8,2,1,15,7};
		int n = arr.length;
		int[] res = new int[n];
		int k = 0;
		for(int i=0;i<n;i++){
			int min = Integer.MAX_VALUE;
			for(int j=0;j<n;j++){
				if(arr[j]>arr[i] && min>arr[j]){
					min=arr[j];
				}
			}
			if(min==Integer.MAX_VALUE) res[k++]=-1;
			else res[k++]=min;
		}
		for(int i=0;i<n;i++) System.out.print(res[i]+" ");
	}
}