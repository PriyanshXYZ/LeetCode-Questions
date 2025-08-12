    class Solution {
        Integer[][] dp = new Integer[302][302];
        int mod = (int)(1e9 + 7);
        public int numberOfWays(int n, int x) {
            int maxBase = (int) Math.pow(n, 1.0 / x);
            
            return memo(n, x, 1);
        }

        private int memo(int n, int x, int currNum) {
            //base case
            if(n<0)return 0;
            if(n==0)return dp[n][currNum] = 1;
            int pow = (int)Math.pow(currNum,x);
            if(pow > n)return 0;

            if(dp[n][currNum] != null) return dp[n][currNum];
            int ans = 0;
            
           
            int possible = memo(n - pow, x, currNum + 1);
            int skip = memo(n, x, currNum + 1);
            ans += (skip % mod + possible % mod) % mod ;
        
            return dp[n][currNum] = ans;
        }
    }