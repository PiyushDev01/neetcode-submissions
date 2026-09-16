class Solution {
    int m,n;
    Integer[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        m= matrix.length;
        n=matrix[0].length;
        dp= new Integer[m][n];
        int ans=0;
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                ans=Math.max(ans, dfs(i,j,-1,matrix));
        
        return ans;
    }
    private int dfs(int i, int j, int pre, int[][] matrix){
        if(i<0||i>=m|| j>=n|| j<0 || matrix[i][j]<=pre)return 0;
        if(dp[i][j]!=null)return dp[i][j];
        int res=1;
        res= Math.max(res,1+dfs(i+1,j, matrix[i][j],matrix));
        res= Math.max(res,1+dfs(i-1,j, matrix[i][j],matrix));
        res= Math.max(res,1+dfs(i,j+1, matrix[i][j],matrix));
        res= Math.max(res,1+dfs(i,j-1, matrix[i][j],matrix));
        return dp[i][j]= res;
    }
}
