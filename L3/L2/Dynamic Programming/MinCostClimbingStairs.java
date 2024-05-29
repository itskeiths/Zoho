/*2.You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you
pay the cost, you can either climb one or two steps.
You can either start from the step with index 0, or the step with index 1.
Return the minimum cost to reach the top of the floor. */

class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + cost[i - 1];
            dp[i] = dp[i] < dp[i - 2] + cost[i - 2] ? dp[i] : dp[i - 2] + cost[i - 2];

        }

        return dp[n];
    }

    public static void main(String[] args) {

        int[] cost1 = { 10, 15, 20 };
        System.out.println("Minimum cost to reach the top floor: " + minCostClimbingStairs(cost1));

        int[] cost2 = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        System.out.println("Minimum cost to reach the top floor: " + minCostClimbingStairs(cost2));
    }
}
