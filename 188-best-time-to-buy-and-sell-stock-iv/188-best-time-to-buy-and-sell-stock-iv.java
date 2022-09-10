class Solution {
    int BUY=0;
    int SELL=1;
    public int maxProfit(int k, int[] prices) {
        return spaceOptimized(k,prices);
//         int[][][] dp=new int[prices.length+1][k+1][2];
//         for(int i=0;i<=prices.length;i++){
//             for(int j=0;j<=k;j++){
//                 Arrays.fill(dp[i][j],-1);
//             }
//         }
        
//         return memo(0,prices,dp,k,BUY);
        // return recursion(0,prices,k,BUY);
    }
    //time complexity O(2^nk) space is recursion call stack
    public int recursion(int idx,int[] prices,int k,int curr){
        if(k==0)return 0;
        if(idx==prices.length)return 0;
        
        if(curr==BUY){
            int buyingCurrStock=recursion(idx+1,prices,k,SELL)-prices[idx];
            int notBuyingCurrStock=recursion(idx+1,prices,k,BUY);
            return Math.max(buyingCurrStock,notBuyingCurrStock);
        }else{
            int sellingCurrStock=recursion(idx+1,prices,k-1,BUY)+prices[idx];
            int notSellingCurrStock=recursion(idx+1,prices,k,SELL);
            return Math.max(sellingCurrStock,notSellingCurrStock);
        }
    }
    //time complexity is O(n*k) space is O(nk)
    public int memo(int idx,int[] prices,int[][][] dp,int k,int curr){
        if(k<0)return Integer.MIN_VALUE;
        if(idx==prices.length){
            return dp[idx][k][curr]=0;
        }
        if(dp[idx][k][curr]!=-1)return dp[idx][k][curr];
        
        if(curr==BUY){
            int buyingCurrStock=memo(idx+1,prices,dp,k,SELL)-prices[idx];
            int notBuyingCurrStock=memo(idx+1,prices,dp,k,BUY);
            dp[idx][k][BUY] = Math.max(buyingCurrStock,notBuyingCurrStock);
            return dp[idx][k][BUY];
        }else{
            int sellingCurrStock=memo(idx+1,prices,dp,k-1,BUY)+prices[idx];
            int notSellingCurrStock=memo(idx+1,prices,dp,k,SELL);
            dp[idx][k][SELL] = Math.max(sellingCurrStock,notSellingCurrStock);
            return dp[idx][k][SELL];
        }
    }
    public int spaceOptimized(int k,int[] s){
        int[][] dp=new int[k+1][2];
        
        for(int idx=s.length-1;idx>=0;idx--){
            int[][] temp=new int[k+1][2];
            for(int tr=0;tr<=k;tr++){
                
                for(int curr=0;curr<2;curr++){
                    if(tr==0){
                        temp[tr][curr]=0;
                        continue;
                    }
                    if(curr==BUY){
                        temp[tr][BUY]=Math.max(dp[tr][SELL]-s[idx],dp[tr][BUY]);
                    }else{
                        temp[tr][SELL]=Math.max(dp[tr-1][BUY]+s[idx],dp[tr][SELL]);
                    }
                }
            }
            dp=temp;
        }
        return dp[k][0];
    }
    
}