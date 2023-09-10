class Solution {
    long[][] dp;
    int mod = (int)(1e9+7);
    public int countOrders(int n) {
        long ans = 1;
        int ways = 3;
        for(int i=2;i<=n;i++){
            long sum = ways*(ways + 1)/2;
            ans = ans*sum;
            ans %= mod;
            ways += 2;
        }
        return (int)ans%mod;
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