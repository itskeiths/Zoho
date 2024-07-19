import java.util.*;
class ArrangeBalls{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of p balls:");
		int p = in.nextInt();
		System.out.println("Enter number of q balls:");
		int q = in.nextInt();
		System.out.println("Enter number of r balls:");
		int r = in.nextInt();
		int[][][][] dp = new int[p+1][q+1][r+1][3];
		for(int[][][] r1 : dp)
				for(int[][] r2:r1){
					for(int[] r3:r2) Arrays.fill(r3,-1);
				}
		System.out.println("Number of ways to arrange: "+(arrange(p-1,q,r,0,dp)+arrange(p,q-1,r,1,dp)+arrange(p,q,r-1,2,dp)));
	}
	
	static int arrange(int p, int q, int r, int last,int[][][][]dp){
		if(p<0 || q<0 || r<0) return 0;
		if(p==0 && q==0 && r==0) return 1;
		if(dp[p][q][r][last]!=-1) return dp[p][q][r][last];
		if(last==0){
			return dp[p][q][r][last]=arrange(p,q-1,r,1,dp)+arrange(p,q,r-1,2,dp);
		}
		if(last==1){
			return dp[p][q][r][last]=arrange(p-1,q,r,0,dp)+arrange(p,q,r-1,2,dp);
		}
		else{
			return dp[p][q][r][last]=arrange(p,q-1,r,1,dp)+arrange(p-1,q,r,0,dp);
		}
	}
}