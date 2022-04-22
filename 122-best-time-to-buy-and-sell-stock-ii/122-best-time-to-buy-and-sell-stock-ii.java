class Solution {
    public int maxProfit(int[] prices) {
        int bp=0;
        int sp=0;
        int profit=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]>prices[sp]){
                sp++;
            }else{
                profit+=prices[sp]-prices[bp];
                sp=bp=i;
            }
        }
        //for corner case of all increasing stocks
        profit+=prices[sp]-prices[bp];
        return profit;
    }
}