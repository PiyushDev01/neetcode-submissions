class Solution {
    Integer[][] dp;
    public int uniquePaths(int m, int n) {
        dp= new Integer[m+1][n+1];
        return solve(m,n,0,0);
    }
    private int solve(int m, int n, int i , int j){
        if(i==m-1 && j==n-1)return 1;
        if(i>=m || j>=n)return 0;
        if(dp[i][j]!=null)return dp[i][j];
        int right= solve(m,n,i+1,j);
        int down= solve(m,n,i,j+1);
        return dp[i][j]= right+down;
    }
}
