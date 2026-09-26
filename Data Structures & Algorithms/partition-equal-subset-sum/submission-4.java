class Solution {
    int n;
    boolean[][] dp;
    public boolean canPartition(int[] nums) {
        n=nums.length;
        int tsum=0;
        for(int i: nums) tsum+=i;
        dp= new boolean[n+1][tsum/2+1];
        if(tsum%2!=0)return false;
       
        for(int i=0; i<=n; i++) dp[i][0]=true;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=tsum/2; j++){
                boolean take=false;
                if(nums[i-1]<=j){

                    take= dp[i-1][j-nums[i-1]];
                }

                boolean skip= dp[i-1][j];
                dp[i][j]=take || skip;
            }
        }
        
        return dp[n][tsum/2];
    }
    
}
