class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs= new HashSet<>(wordDict);
        int maxlen=0;
        for(String i: hs)
            maxlen= Math.max(maxlen, i.length());
        int n= s.length();
        boolean [] dp= new boolean[n+1];
        dp[0]= true;
        for(int i=1; i<=n; i++){
            for(int j=i-1; j>= Math.max(0,i-maxlen); j--){
                if(dp[j] && hs.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];

    }
}