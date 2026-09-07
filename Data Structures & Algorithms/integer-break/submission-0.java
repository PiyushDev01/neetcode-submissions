class Solution {
    public int integerBreak(int n) {
        if(n<=3)return n-1;
        Integer[] dp= new Integer[n+1];
        return solve(n,dp);
    }
    private int solve(int n, Integer[] dp){
        if(n==0)return 1;
        if(dp[n]!=null)return dp[n];
        int ans=0;
        for(int i=1; i<=n;i++){
            if(i<=n){
                ans= Math.max(ans, i*solve(n-i,dp));
            }
        }
        return dp[n]= ans;
    }
}