class Solution {
    int n;
    Integer[] dp;
    public String stoneGameIII(int[] stoneValue) {
        n= stoneValue.length;
        dp= new Integer[n+1];
        int ans= solve(0,stoneValue);
        return ans>0?"Alice": ans<0?"Bob":"Tie";
    }
    private int solve(int i, int[] stones){
        if(i>=n) return 0;
        if(dp[i]!=null)return dp[i];
        int t1= stones[i]-solve(i+1,stones);
        int t2= i<n-1?stones[i]+stones[i+1]-solve(i+2,stones): Integer.MIN_VALUE;
        int t3= i<n-2? stones[i]+stones[i+1]+stones[i+2]-solve(i+3,stones):Integer.MIN_VALUE;

        int take = Math.max(t1, Math.max(t2, t3));
        return dp[i]= take;
    }
}