class Solution {
    long[][] dp;
    int mod = (int)(1e9+7);
    public int countOrders(int n) {
        dp = new long[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return (int)recursion(n,n)%mod;
    }
    
    public long recursion(int pick, int drop){
        if(pick<0 || drop<0)return 0;
        
        if(drop<pick)return 0;
        
        if(pick==0 && drop==0)return 1;
        
        if(dp[pick][drop]!=-1)return dp[pick][drop];
        
        long ans = 0;
        ans += (pick * recursion(pick-1, drop));
        ans %= mod;
        ans += ((drop - pick) * recursion(pick, drop - 1));
        ans %= mod;
        
        return dp[pick][drop] = ans;
    }
}