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
		int i = row-1;
		int j = 0;
		while(i>=0 && j<col){
			if(mat[i][j]<0){
				count+=col-j;
				i--;
			}
			else j++;
		}
		System.out.println(count);
	}
	
}