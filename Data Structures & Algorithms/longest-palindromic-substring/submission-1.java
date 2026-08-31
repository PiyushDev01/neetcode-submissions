class Solution {
    public String longestPalindrome(String s) {
        int n= s.length();
        String res="";
        int reslen=0;
        Boolean[][] dp= new Boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(check(i,j,s,dp)){
                    if(j-i+1 > reslen){
                        reslen=j-i+1;
                        res= s.substring(i,j+1);
                    }
                }
            }
        }
        return res;
    }
    private Boolean check(int i, int j, String s, Boolean[][] dp){
        if(i>=j) return true;
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)) return dp[i][j]= check(i+1,j-1,s,dp);
        else return false;
    }
}
