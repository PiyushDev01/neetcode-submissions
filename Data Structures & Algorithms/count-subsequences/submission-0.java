class Solution {
    Integer[][] dp;
    int m,n;
    public int numDistinct(String s, String t) {
        m=s.length();
        n=t.length();
        dp=new Integer[m][n];
        return solve(0,0,s,t);
    }
    private int solve(int i, int j, String s, String t){
        if(j>=t.length())return 1;
        if(i>=s.length())return 0;
        if(dp[i][j]!=null)return dp[i][j];
        if(s.charAt(i)==t.charAt(j))
            return dp[i][j]= solve(i+1,j+1,s,t)+solve(i+1,j,s,t);
        else
            return dp[i][j]= solve(i+1,j,s,t);
        
    }
}
