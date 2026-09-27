class Solution {
    int n;
    int total;
    Integer [][] dp;
    public int lastStoneWeightII(int[] stones) {
        n= stones.length;
        total=0;
        for(int s: stones) total+=s;
        dp=new Integer[n+1][total+1];
        for(int sum=0; sum<=total; sum++) dp[0][sum]= Math.abs(total-2*sum);

        for(int i=1; i<=n; i++){
            for(int sum=0; sum<=total; sum++){
                int take=0;
                if(sum+stones[i-1]<=total)
                     take= dp[i-1][sum+stones[i-1]];
                int skip= dp[i-1][sum];
                dp[i][sum]=Math.min(take,skip);
            }
        }
        return dp[n][0];
    }
    
}