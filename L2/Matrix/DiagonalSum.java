import java.util.Scanner;
class DigonalSum{
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
		int sum = 0;
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(i==j || i+j==col-1) sum+=mat[i][j];
			}
		}
		System.out.println(sum);
	}
}