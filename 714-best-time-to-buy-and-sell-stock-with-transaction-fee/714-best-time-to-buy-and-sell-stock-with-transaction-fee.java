class Solution {
    public int maxProfit(int[] stock, int fees) {
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
                        int profitWhenSellingHere=+stock[idx] + dp[idx+1][1]-fees;//transaction complete
                        int profitWhenNotSellingHere=dp[idx+1][0];
                        
                        dp[idx][flag]=Math.max(profitWhenSellingHere,profitWhenNotSellingHere);
                    }
                }
            
        }
        return dp[0][1];

    }
}