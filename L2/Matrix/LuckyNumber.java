import java.util.Scanner;
class LuckyNumber{
	public static void main(String[] args){
		int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};
		//int[][] matrix = {{1,10,4,2},{9,3,8,7},{15,16,17,12}};
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int minRow = 0;
		int maxCol = 0;
		int col = 0;
		for(int i=0;i<matrix.length;i++){
			min = Integer.MAX_VALUE;
			for(int j=0;j<matrix[0].length;j++){
				if(matrix[i][j]<min){
					min = matrix[i][j];
					col = j;
				}
			}
			for(int k=0;k<matrix.length;k++){
				if(matrix[k][col]>min){
					maxCol = 0;
					break;
				}
				else{
					minRow = k;
					maxCol = col;
				}
			}
		}
		System.out.println(matrix[minRow][maxCol]);
	}
}