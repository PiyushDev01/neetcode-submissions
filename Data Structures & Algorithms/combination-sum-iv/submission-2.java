class Solution {
    Integer[] dp;

    public int combinationSum4(int[] nums, int target) {
        dp=new Integer[target+1];
        return solve(target, nums);
    }
    private int solve(int target, int[]nums){
        if(target==0)return 1;
        if(dp[target]!=null) return dp[target];
        int count=0;
        for(int i: nums)
            if(i<=target)
                count+= solve(target-i,nums);
        
        return dp[target]= count;
    }
}