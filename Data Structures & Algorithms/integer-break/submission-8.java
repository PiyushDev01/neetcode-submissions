class Solution {
    public int integerBreak(int n) {
        if(n<=3)return n-1;
        int[] dp= new int[n+1];
        dp[0]=1;
        for(int i=1; i<=n; i++){
           
            for(int j=2; j<=n; j++){
                if(j<=i) dp[i]= Math.max(dp[i],j*dp[i-j]);
            }
        }

        return dp[n];
    }



    
}