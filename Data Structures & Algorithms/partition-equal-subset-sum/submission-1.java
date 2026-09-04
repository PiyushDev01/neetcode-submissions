class Solution {
    public boolean canPartition(int[] nums) {
        int n= nums.length;
        int tsum=0;
        for(int i: nums) tsum+=i;
        Boolean[][] dp= new Boolean[n+1][tsum/2+1];
        if(tsum%2!=0)return false;
        return solve(0,tsum/2, nums,dp);
    }
    private boolean solve(int i, int s, int[]nums, Boolean[][] dp){
        if(s==0)return true;
        if(i>= nums.length)return false;
        if(dp[i][s]!=null)return dp[i][s];
        boolean take= false;
        if(s>=nums[i]){       
             take= solve(i+1, s-nums[i],nums,dp);
         }
            boolean skip = solve(i+1, s, nums,dp);
        
        return dp[i][s]= take || skip;
    }
}
