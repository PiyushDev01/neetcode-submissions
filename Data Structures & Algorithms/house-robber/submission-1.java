class Solution {
    public int rob(int[] nums) {
        int n= nums.length;
        Integer[] dp= new Integer[n+1];
        return solve(0,nums,dp);
    }
    private int solve(int i, int[] nums, Integer[] dp ){
        if(i>=nums.length)return 0;
        if(dp[i]!=null)return dp[i];
        int take= nums[i]+solve(i+2,nums,dp);
        int skip= solve(i+1,nums,dp);
        return dp[i]= Math.max(take,skip);
    }
}
