class Solution {
    public int climbStairs(int n) {
        Integer[] dp= new Integer[n+1];
        return solve(n,dp);
    }
    private int solve(int n,Integer[] dp){
        if(dp[n]!=null) return dp[n];
        if(n==1)return 1;
        if(n==2)return 2;
        return dp[n]=solve(n-1,dp)+solve(n-2,dp);
    }
}
