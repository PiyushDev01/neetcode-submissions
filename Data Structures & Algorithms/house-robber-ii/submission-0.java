class Solution {
    public int rob(int[] nums) {
        int n= nums.length;
        int[] dp1= new int[n];
        Arrays.fill(dp1,-1);
        int[] dp2= new int[n];
        Arrays.fill(dp2,-1);
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0],nums[1]);
        
        return Math.max(solve(0,nums,dp1,n-2), solve(1,nums,dp2,n-1));
    }
    private int solve(int i,int[] nums, int[] dp, int n){
        if(i> n)return 0;
        if(dp[i]!= -1)return dp[i];
        int steal= nums[i]+ solve(i+2,nums, dp,n);
        int skip= solve(i+1,nums,dp,n);
        return dp[i]=Math.max(steal,skip);
    }
}
