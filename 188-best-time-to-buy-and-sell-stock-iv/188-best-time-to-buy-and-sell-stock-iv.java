class Solution {
    int BUY=0;
    int SELL=1;
    public int maxProfit(int k, int[] prices) {
        int[][][] dp=new int[prices.length+1][k+1][2];
        for(int i=0;i<=prices.length;i++){
            for(int j=0;j<=k;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return memo(0,prices,dp,k,BUY);
        // return recursion(0,prices,k,BUY);
    }
    //time complexity O(2^n) space is recursion call stack
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
    
}