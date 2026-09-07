class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n= stoneValue.length;
        Integer[] dp= new Integer[n];
        int diff= solve(0, stoneValue,dp);
        if(diff>0) return "Alice";
        if(diff<0) return "Bob";
        return "Tie";
    }
    private int solve(int i, int[] stoneValue,Integer[] dp){
        int n= stoneValue.length;
        if(i>=n)return 0;
        if(dp[i]!= null) return dp[i];
        int res= Integer.MIN_VALUE;
        res= Math.max(res, stoneValue[i]-solve(i+1, stoneValue,dp));
        if(i+1<n)
          res= Math.max(res, stoneValue[i]+stoneValue[i+1]-solve(i+2, stoneValue,dp));
        if(i+2<n)
          res= Math.max(res, stoneValue[i]+stoneValue[i+1]+stoneValue[i+2]-solve(i+3, stoneValue,dp));
        return dp[i]=res;
    }
}