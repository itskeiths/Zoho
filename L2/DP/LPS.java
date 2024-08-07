import java.util.Scanner;
class LPS{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a string:");
		String str = in.next();
		String revstr = new StringBuilder(str).reverse().toString();
		int len = str.length();
		int[][] dp = new int[len+1][len+1];
		for(int i=1;i<=len;i++){
			for(int j=1;j<=len;j++){
				if(str.charAt(i-1)==revstr.charAt(j-1)){
					dp[i][j]=1+dp[i-1][j-1];
				}
				else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}
		System.out.println("Length of longest palindromic subsequence: "+dp[len][len]);
	}
}