class Solution {
    public int minPathSum(int[][] grid) {
         int m=grid.length;
        int n=grid[0].length;
        Integer[][] dp= new Integer[m+1][n+1];
        return solve(0,0,grid,dp);
    }
    private int solve(int i, int j, int[][] grid,Integer[][] dp){
        int m=grid.length;
        int n=grid[0].length;
        if(i==m-1 && j==n-1)return grid[i][j];
        if(i>=m || j>=n)return Integer.MAX_VALUE;
        if(dp[i][j]!=null)return dp[i][j];
        int right = solve(i,j+1,grid,dp);
        int left= solve(i+1,j, grid,dp);
        return dp[i][j]= grid[i][j] +Math.min(right,left);
    }
}