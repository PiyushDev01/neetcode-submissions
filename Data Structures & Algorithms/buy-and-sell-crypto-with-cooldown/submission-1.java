class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] dp= new Integer[prices.length+1][2];
        return solve(prices, 0, true,dp);
    }
    private int solve(int[] prices, int day, boolean buy, Integer[][] dp ){
        int n= prices.length;
        if(day>=n)return 0;
        int t=0;
        if(buy)t=1;
        if(dp[day][t]!=null)return dp[day][t];
        int profit=0;
        if(buy){
            int take= solve(prices, day+1, false,dp)-prices[day];
            int skip= solve(prices,day+1,true,dp);
            profit=Math.max(take,skip);
        }else{
            int sell=solve(prices, day+2,true,dp)+prices[day];
            int skip= solve(prices, day+1,false,dp);
            profit=Math.max(sell,skip);
        }
        return dp[day][t]= profit;
    }
}
