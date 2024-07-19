import java.util.Scanner;
class ClimbingStairs{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter n:");
		int n = in.nextInt();
		int[] dp = new int[n+1];
		dp[0]=1;
		dp[1]=1;
		for(int i=2;i<=n;i++){
			dp[i] = dp[i-1]+dp[i-2];
		}
		System.out.println("Number of ways: "+dp[n]);
	}
}