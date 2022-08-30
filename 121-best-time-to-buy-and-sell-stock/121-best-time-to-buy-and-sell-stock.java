class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int max=0;
        int min=Integer.MAX_VALUE;
        int diff=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(prices[i]<min){
                max=prices[i];
                min=prices[i];
            }else if(max<prices[i]){
                max=prices[i];
            }
            diff=Math.max(max-min,diff);
        }
        return diff;
    }
}