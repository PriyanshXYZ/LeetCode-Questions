class Solution {
    
    private static final int NRML_SELL = 1;
    private static final int SHORT_BUY = 2;

    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        Long[][][] dp = new Long[n+1][k+1][3];
        
        return memo(0, 0, prices, dp, k);
    }

    public long memo(int idx, int typeOfTransaction, int[] prices, Long[][][] dp, int k ) {
        if (idx == prices.length) {
            if (k >= 0 &&  typeOfTransaction == 0)
                return 0;
            return Integer.MIN_VALUE;
        }
        if(k<0)return Integer.MIN_VALUE;
        
        if(dp[idx][k][typeOfTransaction] != null)return dp[idx][k][typeOfTransaction];
        
        long take = Integer.MIN_VALUE;
        long notTake = Integer.MIN_VALUE;
        
        if(typeOfTransaction==NRML_SELL){
            take = prices[idx] + memo(idx+1, 0, prices, dp, k - 1);
        }else if(typeOfTransaction==SHORT_BUY) {
            take = -prices[idx] + memo(idx+1, 0, prices, dp, k - 1);
        }else{
            take = prices[idx] + memo(idx+1, SHORT_BUY, prices, dp, k);
            take =  Math.max((-prices[idx] + memo(idx+1, NRML_SELL, prices, dp, k)), take);
        }
        notTake = memo(idx+1, typeOfTransaction, prices, dp , k);

        return dp[idx][k][typeOfTransaction] = Math.max(take, notTake);
    }
}