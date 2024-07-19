import java.util.*;
public class Game{
	static int[][] matrix = new int[4][4];
		Game(){
		matrix[1][0]=2;
		matrix[2][0]=4;
		matrix[2][1]=4;
		matrix[2][2]=2;
		matrix[3][0]=4;
		matrix[3][3]=2;
	}
	
	public boolean checkOver(){
		for(int i=0;i<4;i++)
		for(int j=0;j<4;j++){
			if(matrix[i][j]==2048){
				System.out.println("Congratulations!");
				System.exit(0);
			}
			if(matrix[i][j]==0) return false;
		}
		return true;
	}
	
	public void generateRandom(){
		Random rand = new Random();
		int row = rand.nextInt(4);
		int col = rand.nextInt(4);
		if(checkOver()){
			System.out.println("Game Over");
			System.exit(0);
		}
		if(matrix[row][col]!=0) generateRandom();
		if(matrix[row][col]==0){
			int random=rand.nextInt(9)/2;
			if(random<2) random=2;
			if(random>2) random = 4;
			matrix[row][col]= random;
		}
	}

	public void leftSum(){	
		for(int i=0;i<4;i++){
			int ele = 0;
			for(int j=0;j<3;j++){
				if(matrix[i][j]==matrix[i][j+1]){
					matrix[i][j]*=2;
					matrix[i][j+1]=0;
				}
			}
		}
	}
	
	public void rightSum(){
		for(int i=0;i<4;i++){
			int ele=0;
			for(int j=3;j>0;j--){
				if(matrix[i][j]==matrix[i][j-1]){
					matrix[i][j]*=2;
					matrix[i][j-1]=0;
				}
			}
		}
	}
		
	public void topSum(){
		for(int j=0;j<4;j++){
			for(int i=0;i<3;i++){
				if(matrix[i][j]==matrix[i+1][j]){
					matrix[i][j]*=2;
					matrix[i+1][j]=0;
				}
			}
		}
		top();
	}
	
	public void bottomSum(){
		for(int j=0;j<4;j++){
			for(int i=3;i>0;i--){
				if(matrix[i][j]==matrix[i-1][j]){
					matrix[i][j]*=2;
					matrix[i-1][j]=0;
				}
			}
		}
	}
	
	public void display(){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(matrix[i][j]==0) System.out.print("-\t");
				else System.out.print(matrix[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public void left(){
		for(int i=0;i<4;i++){
			for(int j=1;j<4;j++){	
				int col=-1;
				if(matrix[i][j]!=0){
					for(int k=j-1;k>=0;k--){
						if(matrix[i][k]==0) col=k;
					}
					if(col!=-1){
						matrix[i][col]=matrix[i][j];
						matrix[i][j]=0;
					}
				}
			}
		}
	}
		
	public void right(){
		for(int i=0;i<4;i++){
			for(int j=2;j>=0;j--){
				int col = -1;
				if(matrix[i][j]!=0){
					for(int k=j+1;k<4;k++){	
						if(matrix[i][k]==0) col=k;
					}
					if(col!=-1){
						matrix[i][col]=matrix[i][j];
						matrix[i][j]=0;
					}
				}
			}
		}
	}

	public void top(){
		for(int j=0;j<4;j++){
			for(int i=1;i<4;i++){
				int row = -1;
				if(matrix[i][j]!=0){
				for(int k=i-1;k>=0;k--){
					if(matrix[k][j]==0) row=k;
				}
				if(row!=-1){
					matrix[row][j]=matrix[i][j];
					matrix[i][j]=0;
				}
				}
			}
		}
	}	
		
	public void bottom(){
		for(int j=0;j<4;j++){
			for(int i=2;i>=0;i--){
				int row=-1;
				if(matrix[i][j]!=0){
					for(int k=i+1;k<4;k++){
						if(matrix[k][j]==0) row=k;
					}
					if(row!=-1){
						matrix[row][j]=matrix[i][j];
						matrix[i][j]=0;
					}
				}
			}
		}
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Game game = new Game();
		game.display();
		while(true){
			System.out.println("Input: ");
			int move = in.nextInt();
			if(move<0 && move>3){
				System.out.println("Invalid move");
				break;
			}
			switch(move){
				case 0:
					game.left();
					game.leftSum();
					game.left();
					game.generateRandom();
					System.out.println();
					game.display();
					break;
				case 1: 
					game.right();
					game.rightSum();
					game.right();
					game.generateRandom();
					System.out.println();
					game.display();
					break;
				case 2:
					game.top();
					game.topSum();
					game.top();
					game.generateRandom();
					System.out.println();
					game.display();
					break;
				case 3:
					game.bottom();
					game.bottomSum();
					game.bottom();
					game.generateRandom();
					System.out.println();
					game.display();
					break;
			}
		}
	}
}