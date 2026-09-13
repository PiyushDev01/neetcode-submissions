class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int s=0; //total sum in nums
        for(int i: nums) s+=i;
        Integer[][]dp= new Integer[n+1][2*s+1];
        return solve(0,0, nums, target,dp,s);
    }
    private int solve(int i,int sum, int[]nums, int target,Integer[][]dp,int s){
        if(i==nums.length)
            if(sum==target)return 1;
            else return 0;
        if(dp[i][sum+s]!=null)return dp[i][sum+s];
        int plus= solve(i+1,sum+nums[i],nums, target,dp,s);
        int minus= solve(i+1, sum-nums[i],nums,target,dp,s);
        return dp[i][sum+s]=plus+minus;
    }
}
