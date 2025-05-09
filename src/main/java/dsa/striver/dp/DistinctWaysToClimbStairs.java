package dsa.striver.dp;

import java.util.Arrays;

public class DistinctWaysToClimbStairs {
    private int helper(int n,int[] dp)
    {
        if(dp[n]!=-1) return dp[n];
        if(n==2|| n==1) return n;
        int oneStepPath=helper(n-1,dp);
        int twoStepPath=helper(n-2,dp);
        dp[n]=oneStepPath+twoStepPath;
        return oneStepPath+twoStepPath;
    }

    public int climbStairs(int n) {
        int[] dp=new int[n+1];//includes n so
        Arrays.fill(dp,-1);
        int ans=helper(n,dp);
        return ans;

    }
}
