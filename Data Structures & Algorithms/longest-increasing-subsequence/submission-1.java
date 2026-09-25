class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        Integer[][] dp= new Integer[n+1][n+1];
        return solve(0,-1,nums, dp);
    }
    private int solve(int i, int pre, int[]nums, Integer[][] dp){
        if(i>=nums.length) return 0;

        if(dp[i][pre+1] != null)return dp[i][pre+1];

        int take = 0;
        if(pre==-1 || nums[pre]< nums[i]){
            take= 1+solve(i+1, i,nums,dp);
        }
        int skip= solve(i+1,pre, nums,dp);

        return dp[i][pre+1]= Math.max(take,skip);
        
    }
}
