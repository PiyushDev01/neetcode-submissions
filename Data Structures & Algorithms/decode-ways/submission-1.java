class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        Integer[]dp= new Integer[n];
        return solve(0,s,dp);
    }
    private int solve(int i, String s,Integer[]dp){
        int n=s.length();
        if(i==n) return 1;
        if(dp[i]!=null) return dp[i];
        if(s.charAt(i)=='0')return dp[i]=0;
        int res= solve(i+1,s,dp);
        if(i+1 < n){
            if(s.charAt(i)=='1'||(s.charAt(i)=='2' && s.charAt(i+1)<='6')){
                res+=solve(i+2,s,dp);
            }
        }
        return dp[i]=res;
    }
}
