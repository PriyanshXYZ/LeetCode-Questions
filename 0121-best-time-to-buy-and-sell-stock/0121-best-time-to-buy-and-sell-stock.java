class Solution {
    public int maxProfit(int[] prices) {
        //approach to this question is we keep a dynamic min till the curr ptr and then we compare if we can get max profit 
        
        int min=Integer.MAX_VALUE;
        int profit = 0;
        for(int val : prices){
            min = Math.min(min , val);
            int currProfit = val - min;
            profit = Math.max(currProfit , profit);
        }
        return profit;
    }
}