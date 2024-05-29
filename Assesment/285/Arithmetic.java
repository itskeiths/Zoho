class Arithmetic{
	public static void main(String[] args){
		//int[] arr = {1,2,3,4};
		int[] arr = {1,3,5,7,9};
		int k = 3;
		int i=0;
		while(i<=arr.length-k){
			int flag = 0;
			int[] res = new int[k];
			int d = arr[i+1]-arr[i];
			int idx = 0;
			for(int j=i;j<arr.length && j<i+k;j++){
				if(j!=arr.length-1 && arr[j+1]-arr[j]!=d){
					flag=1;
					break;
				}
				res[idx++]=arr[j];
			}
			if(flag==0) for(int num:res) System.out.print(num+" ");
			System.out.println();
			i++;
			if(i>arr.length-k) {
				i=0;
				k++;
			}
		}
	}
}
