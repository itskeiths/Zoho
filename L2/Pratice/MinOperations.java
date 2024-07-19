/* Edit Distance: Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')*/

import java.util.*;
class MinOperations{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter word 1:");
		String word1 = in.next();
		System.out.println("Enter word2:");
		String word2 = in.next();
		int m =word1.length(),n=word2.length();
		int[][] dp = new int[m][n];
		for(int[] row:dp) Arrays.fill(row,-1);
		System.out.println(minDis(word1,m-1,word2,n-1,dp));
	}
	
	static int minDis(String word1,int i, String word2, int j, int[][] dp){
		if(i<0) return j+1;
		if(j<0) return i+1;
		if(dp[i][j]!=-1) return dp[i][j];
		if(word1.charAt(i)==word2.charAt(j)){
			return dp[i][j]=minDis(word1,i-1,word2,j-1,dp);
		}
		int insert = 1+minDis(word1,i,word2,j-1,dp);
		int delete = 1+minDis(word1,i-1,word2,j,dp);
		int replace = 1+minDis(word1,i-1,word2,j-1,dp);
		return dp[i][j]=Math.min(insert,Math.min(delete,replace));
	}
}