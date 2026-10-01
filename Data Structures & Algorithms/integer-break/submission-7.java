class Solution {
    Integer[] dp;
    public int integerBreak(int n) {
        if(n<=3)return n-1;
        dp= new Integer[n+1];
        return solve(n);
    }
    private int solve(int n){
        if(n==0)return 1;
        if(dp[n]!=null)return dp[n];
        int ans=0;
        for(int i=2; i<=n;i++){
            if(i<=n) ans=Math.max(ans, i*solve(n-i));
        }
        return dp[n]= ans;
    }
}