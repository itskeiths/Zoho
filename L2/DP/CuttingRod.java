import java.util.*;
class CuttingRod{
	static int maxi=0;
	static int[][] dp ;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the size of rod:");
		int n = in.nextInt();
		int[] prices ={3,5,8,9,10,17,17,20};
		dp = new int[n][n+1];
		for(int[] rows: dp) Arrays.fill(rows,-1);
		System.out.println(cutting(prices,n,n-1,0));
		
	}
	
	static int cutting(int[] prices, int n ,int idx,int sum){
		if(n<0 || idx<0) return 0;
		if(idx==0){
			return sum;
		}
		if(idx<0) return 0;
		if(dp[idx][n]!=-1) return dp[idx][n];
		return dp[idx][n]= Math.max(cutting(prices,n-(idx+1),idx,sum+prices[idx]),
		cutting(prices,n,idx-1,sum));	
	}
}