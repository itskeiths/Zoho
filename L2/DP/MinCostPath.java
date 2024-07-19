import java.util.*;
class MinCostPath{
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
		int[][] dp = new int[R][C];
		for(int[] row:dp) Arrays.fill(row,-1);
		System.out.println("Minimum cost to reach to target: "+minCost(mat,M,N,dp));
	}
	
	static int minCost(int[][] mat, int M , int N , int[][]dp){
		if(M<0 || N<0) return Integer.MAX_VALUE;
		if(M==0 && N==0) return mat[M][N];
		if(dp[M][N]!=-1) return dp[M][N];
	return dp[M][N] = mat[M][N]+ Math.min(minCost(mat,M-1,N,dp),Math.min(minCost(mat,M-1,N-1,dp),minCost(mat,M,N-1,dp)));
	}
}