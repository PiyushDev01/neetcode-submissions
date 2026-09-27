class Solution {
    int n;
    int total;
    Integer [][] dp;
    public int lastStoneWeightII(int[] stones) {
        n= stones.length;
        total=0;
        for(int s: stones) total+=s;
        dp=new Integer[n+1][total+1];
        return solve(0,0,stones);
    }
    private int solve(int i, int curs, int[] stones){
        if(i==n)return Math.abs(total-2* curs);
        if(dp[i][curs]!=null)return dp[i][curs];
        int take= solve(i+1,curs+stones[i],stones);
        int skip= solve(i+1,curs,stones);
        return dp[i][curs]= Math.min(take,skip);
    }
}