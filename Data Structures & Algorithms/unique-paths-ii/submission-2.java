class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m= obstacleGrid.length;
        int n= obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1)return 0;
        Integer[][] dp= new Integer[m+1][n+1];

        return solve(0,0, obstacleGrid,dp);
    }
    private int solve(int i, int j, int[][] obstacleGrid,Integer[][] dp ){
        int m= obstacleGrid.length;
        int n= obstacleGrid[0].length;
        if(dp[i][j]!=null)return dp[i][j];
        //reached last cell
        if(i==m-1 && j==n-1)return 1;
        //outside grid
        if(i>=m || j>=n)return 0;
        //obstacle appears
        if(obstacleGrid[i][j]==1)return 0;

        int right = solve(i,j+1, obstacleGrid,dp);
        int down = solve(i+1,j, obstacleGrid,dp);
        return dp[i][j]=right+down;
    }
}