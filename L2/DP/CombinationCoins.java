import java.util.*;
class CombinationCoins{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of coins:");
		int n = in.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter the coin values:");
		for(int i=0;i<n;i++) arr[i]=in.nextInt();
		System.out.println("Enter the sum:");
		int sum = in.nextInt();
		int[][] dp = new int[n+1][sum+1];
		for(int[] row:dp) Arrays.fill(row,-1);
		System.out.println("Total number of combinations: "+combinations(arr,sum,n,dp));
	}
	
	static int combinations(int[] arr, int sum ,int n,int[][]dp){
		if(sum==0){
			return dp[n][sum]=1;
		}
		if(sum<0 || n==0) return 0;
		if(dp[n][sum]!=-1) return dp[n][sum];
		return dp[n][sum] = combinations(arr,sum-arr[n-1],n,dp)+combinations(arr,sum,n-1,dp);
	}
	
}