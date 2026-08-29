class Solution {
    public int climbStairs(int n) {
        int[] dp= new int[n+1];
        Arrays.fill(dp,-1);
        return steps(n,dp);
    }
    private int steps(int n, int[]dp){
        if(dp[n]!= -1) return dp[n];
        if(n==1)return 1;
        if(n==2)return 2;
        return dp[n]=steps(n-1,dp)+steps(n-2,dp);
    }
}
