class Solution {
    public int rob(int[] nums) {
        int n= nums.length;
        int[] dp= new int[n];
        Arrays.fill(dp, -1);
        int i=0;
        return solve(i, nums,dp);
        
    }
    private int solve(int i, int[]nums, int[]dp){
        if(i>=nums.length)return 0;
        if(dp[i]!=-1)return dp[i];
        int steal= nums[i]+ solve(i+2,nums,dp);
        int skip= solve(i+1,nums,dp);
        return dp[i]= Math.max(steal,skip);
    }
}
