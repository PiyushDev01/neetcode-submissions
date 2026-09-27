class Solution {
    int n;
    int[] suffix;
    Integer[][] dp;

    public int stoneGameII(int[] piles) {
        n=piles.length;
        suffix=new int[n+1];
        dp= new Integer[n][n+1];
        for(int i=n-1; i>=0;i--) suffix[i]=suffix[i+1]+piles[i];
        return solve(0,1,piles);
    }
    private int solve(int i, int M, int[]piles){
        if(i>=n)return 0;
        if(dp[i][M]!=null)return dp[i][M];
        if(2*M >= n-i) return suffix[i];
        int best=0;
        for(int x=1; x<=2*M; x++){
            int opp= solve(i+x, Math.max(M,x),piles);
            int cur= suffix[i]-opp;
            best= Math.max(best, cur);
        }
        return dp[i][M]= best;
    }
}