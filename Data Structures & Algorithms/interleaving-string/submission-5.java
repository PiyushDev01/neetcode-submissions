class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        int m= s1.length();
        int n= s2.length();
        int t= s3.length();
        if(m+n!=t)return false;
        Boolean [][][] dp= new Boolean [m+1][n+1][t+1];
        return solve(0,0,0,s1,s2,s3,dp);
    }
    private boolean solve(int i, int j, int k, String s1, String s2, String s3,Boolean [][][] dp){
        int m= s1.length();
        int n= s2.length();
        int t= s3.length();
        if(i==m && j==n && k==t)return true;
        if(k>=t)return false;
        if(dp[i][j][k]!=null)return dp[i][j][k];
        boolean res= false;

        if(i<m && s1.charAt(i)==s3.charAt(k)) res=solve(i+1,j,k+1,s1,s2,s3,dp);

        if( !res && j<n && s2.charAt(j)==s3.charAt(k)) res= solve(i,j+1,k+1,s1,s2,s3,dp);

        return dp[i][j][k]= res;
    }
}
