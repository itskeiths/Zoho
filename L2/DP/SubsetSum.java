import java.util.*;

class SubsetSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of array:");
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();
        System.out.println("Enter the sum:");
        int sum = in.nextInt();
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++)
            Arrays.fill(dp[i], -1);
        System.out.println("Is subsetSum : " + (subsetSum(arr, sum, n, dp) == 1));
    }

    static int subsetSum(int[] arr, int sum, int n, int[][] dp) {
        if (sum == 0) {
            return 1;
        }
        if (n <= 0)
            return 0;
        if (dp[n][sum] != -1)
            return dp[n][sum];
        if (arr[n - 1] > sum)
            return dp[n][sum] = subsetSum(arr, sum, n - 1, dp);
        else {
            if (subsetSum(arr, sum, n - 1, dp) == 1 || subsetSum(arr, sum - arr[n - 1], n - 1, dp) == 1) {
                return dp[n][sum] = 1;
            } else
                return dp[n][sum] = 0;
        }
    }
}
