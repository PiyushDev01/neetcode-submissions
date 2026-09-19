class Solution {
    int[] arr;
    Integer[][] dp;
    public int maxCoins(int[] nums) {
         int n= nums.length;
         dp= new Integer[n+2][n+2];
         arr= new int[n+2];
         arr[0]=1;
         arr[n+1]=1;
         for(int i=0; i<n; i++)
                arr[i+1]=nums[i];
         return solve(0,n+1);
    }
    private int solve(int l, int r){
        if(l+1>=r)return 0;
        if(dp[l][r]!=null)return dp[l][r];
        int max=0;
        for(int i=l+1; i<r; i++){
            int coin= solve(l,i)+arr[l]*arr[i]*arr[r]+solve(i,r);
            max= Math.max(coin, max);
        }
        return dp[l][r]= max;

    }
}
