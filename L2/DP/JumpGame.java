import java.util.*;
class JumpGame{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the size of array:");
		int n = in.nextInt();
		System.out.println("Enter the elements of array:");
		int[] arr = new int[n];
		for(int i=0;i<n;i++) arr[i]=in.nextInt();
		int[] dp = new int[n];
		Arrays.fill(dp,-1);
		System.out.println("Min Jumps: "+jump(arr,dp,0));
	}
	
	static int jump(int[] arr, int[] dp, int idx){
		if(idx==arr.length-1) return 0;
		if(dp[idx]!=-1) return dp[idx];
		int minsteps = Integer.MAX_VALUE;
		for(int j=arr[idx];j>=1;j--){
			if(idx+j<arr.length){
				minsteps=Math.min(minsteps,1+jump(arr,dp,idx+j));
			}
		}
		return dp[idx]=minsteps;
	}
}