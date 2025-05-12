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
}