class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
         int m=text1.length();
        int n=text2.length();
        Integer [][]dp= new Integer[m+1][n+1];
        return solve(0,0,text1,text2,dp);
    }
    private int solve(int i, int j, String s1, String s2,Integer [][]dp){
        int m=s1.length();
        int n=s2.length();
        if(i==m || j==n)return 0;
        if(dp[i][j]!=null)return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j))return 1+solve(i+1,j+1,s1,s2,dp);
        return dp[i][j]=Math.max(solve(i,j+1,s1,s2,dp),solve(i+1,j,s1,s2,dp));
    }
}
