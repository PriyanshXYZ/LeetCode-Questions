class Solution {
    // final int SELL=1;
    // final int BUY=0;
    int fees;
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int[][] dp =new int[n+1][2];//2 states buy / sell
            fees=fee;
//         for(int i=n;i>=0;i--){
//             for(int flag=0;flag<2;flag++){
//                 if(i==n){
//                     dp[i][flag] = 0;
//                     continue;
//                 }
                
//                 if(flag==SELL){
//                     int profitWhenSellingHere = -prices[i] + dp[i+1][BUY];
//                     int profitWhenNotSellingHere = dp[i+1][SELL];
                    
//                     dp[i][SELL]=Math.max(profitWhenSellingHere,profitWhenNotSellingHere);
//                 }else{
//                     int profitWhenBuyingHere = prices[i] + dp[i+1][SELL]-fee;
//                     int profitWhenNotBuyingHere = dp[i+1][BUY];
                    
//                     dp[i][BUY] = Math.max(profitWhenBuyingHere,profitWhenNotBuyingHere);
//                 }
//             }
//         }
        // return dp[0][SELL];
        return memo(0,n,1,prices,dp);
    }
    public int memo(int idx,int n,int flag,int[] stock,int[][] dp){
        
        if(idx>=n)
            return dp[idx][flag]=0;
        
        if(dp[idx][flag]!=0){
            return dp[idx][flag];
        }

        if(flag==1){
        //buy
            int profitWhenBuyingHere=-stock[idx] + memo(idx+1,n,0,stock,dp);
            int profitWhenNotBuyinhHere=memo(idx+1,n,1,stock,dp);
            return dp[idx][flag]=Math.max(profitWhenBuyingHere,profitWhenNotBuyinhHere);
        }else{
        //sell
            int profitWhenSellingHere=+stock[idx] + memo(idx+1,n, 1 ,stock,dp)-fees;//transaction complete
            int profitWhenNotSellingHere=memo(idx+1,n,0,stock,dp);
            
            return dp[idx][flag]=Math.max(profitWhenSellingHere,profitWhenNotSellingHere);
        }
    }
}