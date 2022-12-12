class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return memo(0,n,dp);
    }
    public int memo(int idx,int n,int[] dp){
        if(idx==n){
            return dp[idx]=1;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int ans=0;
        if(idx+1<=n){
            ans+=memo(idx+1,n,dp);
        }
        if(idx+2<=n){
            ans+=memo(idx+2,n,dp);
        }
        return dp[idx]=ans;
        
    }
}