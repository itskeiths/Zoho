import java.util.*;
class LIS{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of array:");
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();
        int[] dp = new int[n];
		int max = 0;
		for(int i=0;i<n;i++){
			for(int k=i-1;k>=0;k--){
				if(arr[k]<arr[i]){
					dp[i]=Math.max(dp[i],dp[k]);
				}
			}
			dp[i]+=1;
			max=max>dp[i]?max:dp[i];
		}
		System.out.println("Length of longest increasing subsequence is: "+max);
	}
	
}