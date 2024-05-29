class Rectangle{
	public static void main(String[] args){
		int[][] arr = {{1, 2, 3, 4, 6},
			 {5, 3, 8, 1, 2},
			 {4, 6, 7, 5, 5},
			 {2, 4, 8, 9, 4}};
		int m = arr.length,n=arr[0].length;
		int[] start = {2,0};
		int[] end = {3,4};
		if(start[0]>=m || end[0]>=m || start[1]>=n || end[1]>=n){
			System.out.println("Not possible");
			return;
		}
		int sum =0;
		for(int i=start[0];i<=end[0];i++){
			for(int j=start[1];j<=end[1];j++){
				sum+=arr[i][j];
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("Sum: "+sum);
	}
}