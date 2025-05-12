class Solution {
    /*
     1 2 5  14
     5 5 2 2
          0 1 2 3 4 5 6 7 8 9 10 11 12 13 14
        1 M 1 2 3 4 5 6 7 8 9 10 11 12 13 14 
        2 M M 1 2 2 3 3 4 4 5  5  6  6  7  7
        5 M 1 1 2 2 1 2 2 3 3  2  2  2  3  3
    */
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(n==1)return amount%coins[0]>0?-1:amount/coins[0];
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i=0;i<n;i++){
            for(int amt=coins[i];amt<=amount;amt++){
                dp[amt] = Math.min(dp[amt], dp[amt-coins[i]] + 1);
            }
        }

        return dp[amount]!=amount + 1?dp[amount]:-1;
    }
}