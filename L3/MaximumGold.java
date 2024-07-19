import java.util.*;
class MaximumGold{
	static int maxGold = 0;
	static int[][] directions={{0,1},{1,0},{-1,0},{0,-1}};
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter rows and columns:");
		int m =in.nextInt();
		int n = in.nextInt();
		int[][] grid = new int[m][n];
		System.out.println("Enter elements of grid:");
		for(int i=0;i<m;i++) for(int j=0;j<n;j++) grid[i][j]=in.nextInt();
		int[][] visited= new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(grid[i][j]!=0) findPath(i,j,m,n,grid,visited,0);
			}
		}
		System.out.println("Maximum amount of gold collected: "+maxGold);
	}
	
	static void findPath(int x,int y, int m, int n, int[][] grid,int[][] visited,int sum){
		if(visited[x][y]==1) return;
		visited[x][y]=1;
		sum+=grid[x][y];
		if(sum>maxGold) maxGold=sum;	
		for(int dir[]:directions){
			int newX=x+dir[0];
			int newY=y+dir[1];
			if(newX>=0 && newX<m && newY>=0 && newY<n && visited[newX][newY]==0 && grid[newX][newY]!=0){
				findPath(newX,newY,m,n,grid,visited,sum);
			}
		}
		
	}
}