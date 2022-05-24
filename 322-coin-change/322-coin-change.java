class Solution {
    public int coinChange(int[] coins, int amount) {
        // int ans=recursion(coins.length-1,amount,coins);
        // int[][] dp=new int[coins.length][amount+1];
        // int ans=memo(coins.length-1,amount,coins,dp);
        return optimized(coins,amount);
        // return ans<Integer.MAX_VALUE-1?ans:-1;
    }
    //tc O(2^(n+m)) Sc O(log(n+m))
    public int recursion(int n,int target,int[] coins){
        if(target==0)return 0;
        if(n<0 || target<0)return Integer.MAX_VALUE-1;
        int inc=0,exc=0;
        inc=recursion(n,target-coins[n],coins)+1;//path is included so add this to ans
        exc=recursion(n-1,target,coins);
        return Math.min(inc,exc);
    }
    //tc O(n*m) Sc O(n*m)
    public int memo(int n,int target,int[] coins,int[][] dp){
        if(target==0)return dp[n][target]=0;
        if(n<0 || target<0)return Integer.MAX_VALUE-1;
        if(dp[n][target]!=0)return dp[n][target];
        int inc=0,exc=0;
        inc=memo(n,target-coins[n],coins,dp)+1;//path is included so add this to ans
        exc=memo(n-1,target,coins,dp);
        return dp[n][target]=Math.min(inc,exc);
    }
    //tc O(n*m) Sc O(n*m)
    public int tabulation(int[] coins, int amount){
        int[][] dp=new int[coins.length][amount+1];
        int n=coins.length;
        for(int idx=0;idx<n;idx++){
            for(int amt=0;amt<=amount;amt++){
                if(amt==0){
                    dp[idx][amt]=0;
                    continue;
                }
                
                int inc=Integer.MAX_VALUE-1;
                if(amt-coins[idx]>=0)
                    inc=dp[idx][amt-coins[idx]]+1;
                
                int exc=Integer.MAX_VALUE-1;
                if(idx>=1)
                    exc=dp[idx-1][amt];
                
                dp[idx][amt]=Math.min(inc,exc);
            }
        }
         return dp[n-1][amount]<Integer.MAX_VALUE-1?dp[n-1][amount]:-1;
    }
    
    public int optimized(int[] coins, int amount){
        if(amount==0)return 0;
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        int ans=Integer.MAX_VALUE;
        for(int coin:coins){
            for(int amt=coin;amt<=amount;amt++){
                dp[amt]=Math.min(dp[amt],dp[amt-coin]+1);
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
    
}