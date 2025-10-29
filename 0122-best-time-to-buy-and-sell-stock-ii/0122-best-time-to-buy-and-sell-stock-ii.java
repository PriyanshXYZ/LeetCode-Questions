class Solution {
    public int maxProfit(int[] prices) {
        //neigbouring peak sum > global peak diff
        int n  = prices.length;
        int bp = 0;
        int sp = 0;
        int profit = 0;

        for(int i = 0 ; i < n; i++ ) {
            if(prices[i] > prices[sp]) {
                sp=i;
            }else {
                profit += prices[sp] - prices[bp];
                sp = bp = i;
            }
        }
        profit += prices[sp] - prices[bp];
        return profit;
    }
}