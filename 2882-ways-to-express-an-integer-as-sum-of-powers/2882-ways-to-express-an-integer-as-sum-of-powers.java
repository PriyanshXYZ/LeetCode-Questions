class Solution {
    public int numberOfWays(int n, int x) {
        final int MOD = 1_000_000_007;
        
        // dp[i] stores the number of ways to form sum i
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: one way to form a sum of 0

        // Find all unique positive integers whose x-th power is <= n
        for (int i = 1; ; i++) {
            long power = (long) Math.pow(i, x);
            
            if (power > n) {
                break;
            }
            
            // Iterate backwards to avoid using the same power multiple times
            // in a single combination.
            for (int j = n; j >= power; j--) {
                dp[j] = (dp[j] + dp[j - (int) power]) % MOD;
            }
        }
        
        return dp[n];
    }
}