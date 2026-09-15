class Solution {
    
    public int rob(int[] nums) {
        int n= nums.length;
        Integer[] dp1= new Integer[n+1];
        Integer[] dp2= new Integer[n+1];
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0],nums[1]);
        return Math.max(solve(0,n-1,nums,dp1),solve(1,n,nums,dp2));
    }
    private int solve(int i, int n,int[]nums, Integer[] dp){
        if(i>=n)return 0;
        if(dp[i]!=null)return dp[i];
        int take= nums[i]+solve(i+2,n,nums,dp);
        int skip= solve(i+1,n,nums,dp);
        return dp[i]=Math.max(take,skip);
    }
}