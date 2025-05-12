class Solution {
    /*
      0 1 2 3 4 5
    1 1 1 1 1 1 1
    2 1 1 2 2 3 3 
    5 1 1 2 2 3 3
    */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin : coins) {
            for(int amt = coin;amt<=amount;amt++){
                dp[amt] += dp[amt - coin];
            }
        }
        return dp[amount];
    }
    public int tabulation(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        // Initialize base cases
        // When amount is 0, we have 1 way to make it (using no coins)
        for (int j = 0; j <= coins.length; j++) {
            dp[0][j] = 1;
        }
        
        // Fill the dp table
        for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {
            for (int coinIndex = coins.length - 1; coinIndex >= 0; coinIndex--) {
                // Copy the value from the state without using current coin
                dp[currentAmount][coinIndex] = dp[currentAmount][coinIndex + 1];
                
                // If we can use the current coin, add combinations
                if (currentAmount >= coins[coinIndex]) {
                    dp[currentAmount][coinIndex] += 
                        dp[currentAmount - coins[coinIndex]][coinIndex];
                }
            }
        }
        
        // Return final answer
        return dp[amount][0];
    }
    
    public int recursion(int idx, int amountLeft , int[] coins) {
        //base case
        if(idx < 0)return 0;
        if(amountLeft == 0)return 1;
        if(amountLeft < 0)return 0;
        
        // if(dp[amountLeft][idx] !=-1) return dp[amountLeft][idx];
        
        int ans = 0;
        for(int i = idx;i>=0; i--) {
            ans += recursion(i, amountLeft - coins[i], coins);
            
        }
        return ans;
    }
}