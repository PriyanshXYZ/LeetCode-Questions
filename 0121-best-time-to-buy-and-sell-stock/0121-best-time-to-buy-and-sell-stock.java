class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int currMin = Integer.MAX_VALUE;
        int profit = 0;
        
        for(int i = 0; i < n; i++) {
            currMin = Math.min(currMin, prices[i]);
            int currDiff = prices[i] - currMin;
            profit = Math.max(currDiff, profit);
        }
        return profit;
    }
}