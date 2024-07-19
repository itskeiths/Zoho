import java.util.Scanner;
class SetMatrixZeros{
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
		int cols = 0;
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(matrix[i][j]==0){
					matrix[i][0]=0;
					if(j==0) cols=1;
					else matrix[0][j]=0;
				}
			}
		}
		for(int i=1;i<row;i++){
			for(int j=1;j<col;j++){
				if(matrix[i][j]!=0){
					if(matrix[i][0]==0 || matrix[0][j]==0) matrix[i][j]=0;
				}
			}
		}
		if(matrix[0][0]==0) for(int i=0;i<col;i++) matrix[0][i]=0;
		if(cols==1) for(int i=0;i<row;i++) matrix[i][0]=0;
		System.out.println("New Matrix:");
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++) System.out.print(matrix[i][j]+" ");
			System.out.println();
		}
	}
}