class Solution {
    public int countSubstrings(String s) {
        int count=0;
        int n= s.length();
        Boolean[][] dp= new Boolean[n][n];
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                if(check(i,j,s,dp)){
                    count++;
                }
            }
        }
        return count;
    }
    private boolean check(int i, int j, String s, Boolean[][] dp){
        if(i>= j)return true;
        if(dp[i][j]!=null)return dp[i][j];
        if(s.charAt(i)==s.charAt(j)) return dp[i][j]= check(i+1,j-1,s,dp);
        else return dp[i][j]= false;
    }
}
