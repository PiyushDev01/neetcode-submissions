class Solution {
    public int numSquares(int n) {
        int[] dp= new int [n+1];
        dp[0]= 0;
        for(int x=1; x <= n; x++){
            dp[x]= Integer.MAX_VALUE;
            for(int i=1; i*i<=x; i++){
                dp[x]= Math.min(dp[x], 1+ dp[x-i*i]);
            }
        }
        return dp[n];
    }
}