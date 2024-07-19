import java.util.Scanner;
class KWeakestRows{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter rows and cols:");
		int row = in.nextInt();
		int col = in.nextInt();
		System.out.println("Enter elements of matrix:");
		int[][] matrix = new int[row][col];
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++) matrix[i][j]=in.nextInt(); 
		}
		System.out.println("Enter k:");
		int k = in.nextInt();
		int[] order = new int[row];
		for(int i=0;i<row;i++){
			int count=0;
			for(int j=0;j<col;j++){
				if(matrix[i][j]==1) count++;
			}
			order[i]=count;
		}
		int min = Integer.MAX_VALUE;
		int cur = Integer.MIN_VALUE;
		int minRow = 0;
		for(int i=0;i<row;i++){
			min=Integer.MAX_VALUE;
			for(int j=0;j<row;j++){
				if(order[j]<min && order[j]>cur){
					min=order[j];
					minRow = j;
					cur = min;
				}
			}
			System.out.print(minRow+" ");
			if(k--<0) break;
		}
	}
}