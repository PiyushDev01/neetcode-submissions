class Solution {
    int n;
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        n=nums.length;
        int tsum=0;
        for(int i: nums) tsum+=i;
        dp= new Boolean[n+1][tsum/2+1];
        if(tsum%2!=0)return false;
        return solve(0,tsum/2, nums);
    }
    private boolean solve(int i, int t, int [] nums){
        
        if(t==0)return true;
        if(i>=n)return false;
        if(dp[i][t]!=null)return dp[i][t];
        boolean take=false;
        if(nums[i]<=t)
            take= solve(i+1,t-nums[i], nums);

        boolean skip= solve(i+1,t,nums);

        return dp[i][t]= take || skip;
    }
}
