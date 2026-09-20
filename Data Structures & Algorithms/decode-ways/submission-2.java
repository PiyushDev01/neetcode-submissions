class Solution {
    int n;
    Integer[] dp;
    public int numDecodings(String s) {
        n=s.length();
        dp= new Integer[n+1];
        return solve(0,s);
    }
    private int solve(int i, String s){
        if(i==n)return 1;
        if(s.charAt(i)=='0')return 0;
        if(dp[i]!=null)return dp[i];
        int res= solve(i+1,s);
        if(i+1<n){
            if(s.charAt(i)=='1'||(s.charAt(i)=='2' && s.charAt(i+1)<='6'))
                res+=solve(i+2,s);
        }
        return dp[i]=res;
    }
}
