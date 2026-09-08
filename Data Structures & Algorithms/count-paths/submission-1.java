class Solution {
    public int uniquePaths(int m, int n) {
        Integer[][]dp= new Integer[m][n];
        return solve(m,n,0,0,dp);
    }
    private int solve(int m,int n, int i, int j, Integer[][] dp){
        if(i==m-1||j==n-1)return 1;
        if(i>=m || j>=n) return 0;
        if(dp[i][j]!=null)return dp[i][j];
        int right = solve(m,n,i,j+1,dp);
        int down= solve(m,n,i+1, j,dp);
        return dp[i][j]= right+down;
    }
}
