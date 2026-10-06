class Solution {
    Integer[][] dp;
    public int uniquePaths(int m, int n) {
        dp= new Integer[m][n];
        for(int i=0; i<m;i++) dp[i][0]=1;
        for(int j=0;j<n; j++) dp[0][j]=1;

        for(int i=1; i<m;i++){
            for(int j=1; j<n; j++ ){
               
                // int right= solve(m-1,n);
                int right= dp[i-1][j];
                // int down= solve(m,n-1);
                int down= dp[i][j-1];
                // return dp[m][n]=right+down;
                dp[i][j]= right+down;
            }
        }    

         return dp[m-1][n-1];

    }}