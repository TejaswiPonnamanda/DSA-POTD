package dsa.striver.dp;

import java.util.Arrays;

public class MinCostClimbingStairs {
    private int[] dp;

    private int helper(int[] cost, int i) {
        if (i >= cost.length) return 0;
        if (dp[i] != -1) return dp[i];

        int oneStep = helper(cost, i + 1);
        int twoStep = helper(cost, i + 2);
        dp[i] = cost[i] + Math.min(oneStep, twoStep);
        return cost[i] + Math.min(oneStep, twoStep);
    }

    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(helper(cost, 0), helper(cost, 1));
    }
}

