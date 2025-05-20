class Solution {
    private static final int BUY = 0;
    private static final int SELL = 1;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][][] dp = new Integer[n][2][2];
        return getMaxProfit(0, 0, BUY, prices, dp);
    }
    private static int getMaxProfit(int idx, int transaction, int buyOrSell, int[] prices , Integer[][][] dp) {
        //base case 
        if(idx >= prices.length || transaction>=2)return 0;

        
        if(dp[idx][buyOrSell][transaction] != null)return dp[idx][buyOrSell][transaction];

        //main logic
        int ans = 0;
        if(buyOrSell == BUY){
            int currProfit = -prices[idx];
            int nextSellPrice = getMaxProfit(idx + 1, transaction, SELL, prices, dp);
            int notBuyedHere = getMaxProfit(idx + 1, transaction, BUY, prices, dp);
            currProfit += nextSellPrice;
            ans = Math.max(currProfit , notBuyedHere);
        }else{
            int currProfit = prices[idx];
            int nextBuyPrice = getMaxProfit(idx + 1, transaction + 1, BUY, prices, dp);
            int notSellHere = getMaxProfit(idx + 1, transaction, SELL, prices, dp);
            currProfit += nextBuyPrice;
            ans = Math.max(currProfit, notSellHere);
        }
        return dp[idx][buyOrSell][transaction] = ans;
    }
}