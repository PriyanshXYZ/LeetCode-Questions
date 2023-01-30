class Solution {
    Integer[] dp = new Integer[38];
    public int tribonacci(int n) {
        if(n==0)return 0;
        if(n==1 || n==2)return 1;
        if(dp[n]!=null)return dp[n];
        return dp[n] = tribonacci(n-1)+ tribonacci(n-2) + tribonacci(n-3);
    }
}