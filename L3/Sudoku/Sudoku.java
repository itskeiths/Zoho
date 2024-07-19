import java.util.*;
class Sudoku{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of testcases:");
		int testcase = in.nextInt();
		for(int l=0;l<testcase;l++){
			System.out.println("Input");
			char[][] board = new char[9][9];
			for(int i=0;i<9;i++){
				for(int j=0;j<9;j++){
					board[i][j]=in.next().charAt(0);
				}
			}
			solveSudoku(board);
			display(board);
		}
	}
	
	static void display(char[][] board){
		System.out.println("Excepted Output:");
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static void solveSudoku(char[][] board){
		int[][] f = new int[9][10];
		int[][] row = new int[9][10];
		int[][] col = new int[9][10];
		int cell = 0;
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				cell = ((i/3)*3)+j/3;
				if(board[i][j]!='.'){
					f[cell][(int)board[i][j]-'0']=1;
					row[i][(int)board[i][j]-'0']=1;
					col[j][(int)board[i][j]-'0']=1;
				}
			}
		}
		if(!fill(f,board,0,0,row,col)){
			System.out.println("Invalid Sudoku");
			System.exit(1);
		}
	}
	
	static boolean fill(int[][] f, char[][] board, int i, int j, int[][] row, int[][] col){
		if(i==9) return true;
		if(board[i][j]!='.'){
			if(j==8){
				return fill(f,board,i+1,0,row,col);
			}
			else return fill(f,board,i,j+1,row,col);
		}
		else{
			boolean t = false;
			int cell = ((i/3)*3)+j/3;
			for(int k=1;k<=9;k++){
				if(f[cell][k]==0 && row[i][k]==0 && col[j][k]==0){
					f[cell][k]=1;
					row[i][k]=1;
					col[j][k]=1;
					board[i][j]=(char)(k+'0');
					if(j==8) t=fill(f,board,i+1,0,row,col);
					else t = fill(f,board,i,j+1,row,col);
					if(t) return true;
					f[cell][k]=0;
					row[i][k]=0;
					col[j][k]=0;
					board[i][j]='.';
				}
			}
		}
		return false;
	}
}