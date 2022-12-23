class Solution {
    public int maxProfit(int[] stock) {
        Integer[][] dp = new Integer[stock.length][2];
        // return recursion(0,stock,0);
        // return memo(0, 0, stock, dp);
        return tabulation(stock);
    }
    public int tabulation(int[] stock){
        int n=stock.length;
        int[][] dp=new int[n+2][2];
        for(int idx=n;idx>=0;idx--){
            for(int flag=0;flag<2;flag++){
                
                    if(idx==n){
                        dp[idx][flag]=0;
                        continue;
                    }

                    if(flag==1){
                    //buy
                        int profitWhenBuyingHere=-stock[idx] + dp[idx+1][0];
                        int profitWhenNotBuyinhHere=dp[idx+1][1];
                        dp[idx][flag]=Math.max(profitWhenBuyingHere,profitWhenNotBuyinhHere);
                    }else{
                    //sell
                        int profitWhenSellingHere=+stock[idx] + dp[idx+2][1];//transaction complete
                        int profitWhenNotSellingHere=dp[idx+1][0];
                        
                        dp[idx][flag]=Math.max(profitWhenSellingHere,profitWhenNotSellingHere);
                    }
                }
            
        }
        return dp[0][1];
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



