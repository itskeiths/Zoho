import java.util.*;
class LSDifference{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of array:");
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();
        int[] dp = new int[n];
		for(int i=0;i<n;i++){
			for(int k=i-1;k>=0;k--){
				if(Math.abs(arr[k]-arr[i])==1){
					dp[i]=Math.max(dp[i],dp[k]);
				}
			}
			dp[i]+=1;
		}
		int max=0;
		for(int num:dp) max=max>num?max:num;
		System.out.println("Length of Longest subsequence with difference with adjacent one is: "+max);
	}
	
}