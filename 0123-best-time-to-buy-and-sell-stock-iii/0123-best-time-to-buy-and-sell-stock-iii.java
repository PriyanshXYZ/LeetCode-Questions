class Solution {
    private static final int BUY = 0;
    private static final int SELL = 1;
    public int tabulation(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        
        int[][][] dp = new int[n][2]  [3]; // [day][buy or sell][transactions completed]

        // Initialization for day 0
        for (int t = 0; t <= 2; t++) {
            dp[0][BUY][t] = -prices[0];  // If we buy on day 0, we spent money
            dp[0][SELL][t] = 0;           // If we don't hold stock, profit = 0
        }


        for (int i = 1; i < n; i++) {
            for (int t = 1; t <= 2; t++) {
                dp[i][SELL][t] = Math.max(dp[i-1][SELL][t], dp[i-1][BUY][t] + prices[i]);
                dp[i][BUY][t] = Math.max(dp[i-1][BUY][t], dp[i-1][SELL][t-1] - prices[i]);
            }
        }
        
        return dp[n-1][SELL][2]; // max profit with 2 transactions and can buy (no stock in hand)
    }
    public int maxProfit(int[] prices) {
        
        int buy1 = Integer.MIN_VALUE, sell1 = 0;
        int buy2 = Integer.MIN_VALUE, sell2 = 0;

        for (int price : prices) {
            buy1  = Math.max(buy1, -price);          // first buy
            sell1 = Math.max(sell1, buy1 + price);   // first sell
            buy2  = Math.max(buy2, sell1 - price);   // second buy
            sell2 = Math.max(sell2, buy2 + price);   // second sell
        }

        return sell2;
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