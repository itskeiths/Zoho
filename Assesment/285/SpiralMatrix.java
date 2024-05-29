class SpiralMatrix{
	public static void main(String args[]){
		int[][] arr={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		//int[][] arr ={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int m = arr.length;
		int n = arr[0].length;
		int[] res = new int[m*n];
		int k =0;
		int left = 0, right=n-1,up=0,bottom=m-1;
		while(k<m*n){
			for(int i=left;i<right;i++) if(k<m*n) res[k++] = arr[left][i];
			for(int i=up;i<bottom;i++) if(k<m*n) res[k++] =arr[i][right];
			for(int i=right;i>left;i--) if(k<m*n) res[k++] = arr[bottom][i];
			for(int i=bottom;i>up;i--) if(k<m*n) res[k++] = arr[i][left];
			left++;
			right--;
			up++;
			bottom--;
		}
		for(int i=0;i<m*n;i++) System.out.print(res[i]+" ");
	}
}