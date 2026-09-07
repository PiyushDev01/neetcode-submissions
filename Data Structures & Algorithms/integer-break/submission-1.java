class Solution {
    public int integerBreak(int n) {
        if(n<=3)return n-1;
        int[] dp= new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
    private int solve(int n, int[] dp){
        if(n==0)return 1;
        if(dp[n]!=-1)return dp[n];
        int ans=0;
        for(int i=1; i<=n;i++){
            if(i<=n){
                ans= Math.max(ans, i*solve(n-i,dp));
            }
        }
        return dp[n]= ans;
    }
}