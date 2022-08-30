class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int sellpt=0;
        int buypt=0;
        int sell=0;
        for(int i=1;i<n;i++){
            if(prices[i]>=prices[i-1]){
                sellpt++;
            }else{
                sell+=prices[sellpt]-prices[buypt];
                buypt=sellpt=i;
            }
        }
        sell+=prices[sellpt]-prices[buypt];
        return sell;
    }
}