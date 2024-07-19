import java.util.Scanner;
class LongestIncreasingPath{
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
		int res = 0;
		int[][] dp = new int[row][col];
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				res = Math.max(res,dfs(mat,i,j,dp,-1));
			}
		}
		System.out.println(res);
	}
	
	static int dfs(int[][] mat,int i, int j , int[][]dp,int prev){
		if(i<0 || i>=mat.length || j<0 || j>=mat[0].length || mat[i][j]<=prev) return 0;
		if(dp[i][j]!=0) return dp[i][j];
		int temp = 0;
		prev = mat[i][j];
		temp = Math.max(temp,dfs(mat,i,j-1,dp,prev));
		temp = Math.max(temp,dfs(mat,i,j+1,dp,prev));
		temp = Math.max(temp,dfs(mat,i-1,j,dp,prev));
		temp = Math.max(temp,dfs(mat,i+1,j,dp,prev));
		return dp[i][j]=++temp;
	}
}