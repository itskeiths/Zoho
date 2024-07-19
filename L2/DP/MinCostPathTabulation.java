import java.util.*;
class MinCostPathTabulation{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter row and column:");
		int R = in.nextInt();
		int C = in.nextInt();
		int[][] mat = new int[R][C];
		System.out.println("Enter elements of matrix:");
		for(int i=0;i<R;i++) for(int j=0;j<C;j++) mat[i][j]=in.nextInt();
		System.out.println("Enter the target Row and column:");
		int M = in.nextInt();
		int N = in.nextInt();
		System.out.println("Minimum cost to reach to target: "+minCost(mat,M,N));
	}
	
	static int minCost(int[][] mat, int M , int N){
		int[][] dp = new int[M+1][N+1];
		dp[0][0]= mat[0][0];
		for(int i=1;i<=M;i++) dp[i][0]= mat[i][0]+dp[i-1][0];
		for(int j=1;j<=N;j++) dp[0][j] = mat[0][j]+dp[j-1][0];
		for(int i=1;i<=M;i++){
			for(int j=1;j<=M;j++){
				dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+mat[i][j];
			}
		}
		return dp[M][N];
	}
}