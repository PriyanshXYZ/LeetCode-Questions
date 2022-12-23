class Solution {
    public int maxProfit(int[] stock) {
        Integer[][] dp = new Integer[stock.length][2];
        // return recursion(0,stock,0);
        return memo(0, 0, stock, dp);
    }
    public int recursion(int idx, int[] stocks, int flag){//flag 0 => buy and flag 1 =>sell
        if(idx>=stocks.length)return 0;
        
        if(flag == 0){
            int buyStockHere = -stocks[idx] + recursion(idx + 1, stocks, 1);
            int notBuyStockHere = recursion(idx + 1, stocks, 0);
            return Math.max(buyStockHere,notBuyStockHere);
        }else{
            int sellStockHere = +stocks[idx] + recursion(idx + 2, stocks, 0);
            int notSellStockHere = recursion(idx + 1, stocks, 1);
            return Math.max(sellStockHere, notSellStockHere);
        }
    }
    public int memo(int idx, int flag, int[] stocks, Integer[][] dp){
        if(idx>=stocks.length)return 0;
        
        if(dp[idx][flag]!=null)return dp[idx][flag];
        if(flag == 0){
            int buyStockHere = -stocks[idx] + memo(idx + 1, 1, stocks, dp);
            int notBuyStockHere = memo(idx + 1, 0, stocks, dp);
            return dp[idx][flag] = Math.max(buyStockHere,notBuyStockHere);
        }else{
            int sellStockHere = +stocks[idx] + memo(idx + 2, 0, stocks, dp);
            int notSellStockHere = memo(idx + 1, 1, stocks, dp);
            return dp[idx][flag] = Math.max(sellStockHere, notSellStockHere);
        }
    }
}



