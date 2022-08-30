class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int buy=prices[0];
        int sell=0;
        for(int i=1;i<n;i++){
            buy=Math.min(buy,prices[i]);
            int currProfit=prices[i]-buy;
            sell=Math.max(currProfit,sell);
        }
        return sell;
    }
}