class Solution {
    public int numWays(int steps, int arrLen) {
        arrLen = Math.min(steps, arrLen);
        dp = new Integer[arrLen][steps+1];
        
        return recursion(0, steps, arrLen);
    }
    int mod = (int)(1e9+7);
    Integer[][] dp;
    public int recursion(int idx, int steps, int size){
        if(steps==0){
            if(idx==0)return 1;
            return 0;
        }
        if(dp[idx][steps]!=null)return dp[idx][steps];
        int ans = 0;
        if(idx + 1 < size){
            ans += recursion(idx + 1, steps - 1, size);
            ans %= mod;
        }
        
        ans += recursion(idx, steps - 1, size);
        ans %= mod;
        
        if(idx - 1 >= 0){
            ans += recursion(idx - 1, steps - 1, size);
            ans %= mod;
        }
        return dp[idx][steps] = ans;
    }
}