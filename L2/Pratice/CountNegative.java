import java.util.Scanner;
class CountNegative{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter rows and cols:");
		int row = in.nextInt();
		int col = in.nextInt();
		System.out.println("Enter elements of matrix:");
		int[][] mat = new int[row][col];
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++) mat[i][j]=in.nextInt(); 
		}
		int count = 0;
		for(int i=0;i<row;i++){
			count+=binarySearch(mat,i);
		}
		System.out.println(count);
	}
	
	static int binarySearch(int[][] mat, int row){
		int n = mat.length-1;
		int low = 0, high = n;
		while(low<=high){
			int mid = (high+low)/2;
			if(mat[row][mid]<0 && mat[row][mid]-1>=0) return n-mid;
			else if(mid[row][mid]>0) low=mid+1;
			else high = mid-1;
		}
		return 0;
	}
}