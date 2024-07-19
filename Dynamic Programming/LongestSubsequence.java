import java.util.*;
public class LongestSubsequence {
    public static void main(String...args) {
        int[] arr = {4,2,6};
	int n = arr.length;
        int[][] dp =new int[n][n+1];
	for(int[] row:dp){
		Arrays.fill(row,-1);
	}

        System.out.println(findLarge(arr,0,-1,dp));
    }

    public static int findLarge(int[] arr,int ind, int prev_ind,int[][]dp) {
     	if(ind==arr.length) return 0;
	if(dp[ind][prev_ind+1]!=-1) return dp[ind][prev_ind];
	int nottake = 0+findLarge(arr,ind+1,prev_ind,dp);
	int take=0;
	if(prev_ind==-1 || arr[ind]>arr[prev_ind]){
		take = 1+ findLarge(arr,ind+1,ind,dp);
	}
	return dp[ind][prev_ind+1]=Math.max(take,nottake);
    }
}
