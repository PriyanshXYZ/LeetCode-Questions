class Solution {
    final int SELL=1;
    final int BUY=0;
    int fees;
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int[][] dp =new int[n+1][2];//2 states buy / sell
            fees=fee;
        for(int i=n;i>=0;i--){
            for(int flag=1;flag>=0;flag--){
                if(i==n){
                    dp[i][flag] = 0;
                    continue;
                }
                
                if(flag==BUY){
                    int profitWhenBuyingHere = -prices[i] + dp[i+1][SELL];
                    int profitWhenNotBuyingHere = dp[i+1][BUY];
                    
                    dp[i][BUY]=Math.max(profitWhenBuyingHere,profitWhenNotBuyingHere);
                }else{
                    int profitWhenSellingHere = prices[i] + dp[i+1][BUY]-fee;
                    int profitWhenNotSellingHere = dp[i+1][SELL];
                    
                    dp[i][SELL] = Math.max(profitWhenSellingHere,profitWhenNotSellingHere);
                }
            }
        }
        
        return dp[0][BUY];
    }
    
}