class Solution {
    final int SELL=1;
    final int BUY=0;
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int[][] dp =new int[n+1][2];//2 states buy / sell
        
        for(int i=n;i>=0;i--){
            for(int flag=0;flag<2;flag++){
                if(i==n){
                    dp[i][flag]=0;
                    continue;
                }
                
                if(flag==SELL){
                    int profitWhenSellingHere=-prices[i]+dp[i+1][BUY];
                    int profitWhenNotSellingHere=dp[i+1][SELL];
                    
                    dp[i][SELL]=Math.max(profitWhenSellingHere,profitWhenNotSellingHere);
                }else{
                    int profitWhenBuyingHere=prices[i]+dp[i+1][SELL]-fee;
                    int profitWhenNotBuyingHere=dp[i+1][BUY];
                    
                    dp[i][BUY]=Math.max(profitWhenBuyingHere,profitWhenNotBuyingHere);
                }
            }
        }
        return dp[0][SELL];
    }
}