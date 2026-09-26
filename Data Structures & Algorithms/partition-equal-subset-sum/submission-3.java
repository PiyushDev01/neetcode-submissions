class Solution {
    int n;
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        n=nums.length;
        int tsum=0;
        for(int i: nums) tsum+=i;
        dp= new Boolean[n+1][tsum/2+1];
        if(tsum%2!=0)return false;
        return solve(n,tsum/2, nums);
    }
    private boolean solve(int n, int t, int [] nums){
        
        if(t==0)return true;
        if(n==0)return false;
        if(dp[n-1][t]!=null)return dp[n-1][t];
        boolean take=false;
        if(nums[n-1]<=t)
            take= solve(n-1,t-nums[n-1], nums);

        boolean skip= solve(n-1,t,nums);

        return dp[n-1][t]= take || skip;
    }
}
