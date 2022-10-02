class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        // return recursion(0,n,k,target);
        Integer[][][] dp=new Integer[n+1][k+1][target+1];
        return memo(n,k,target,dp);
    }
    // k^n tc
    public int recursion(int dice,int n,int k,int target){
        //base case
        if(dice==n){
            if(target==0){
                return 1;
            }else return 0;
        }
        int ans=0;
        for(int i=1;i<=k;i++){
            if(target-i>=0){
                ans+=recursion(dice+1,n,k,target-i);
            }
        }
        return ans;
    }
    int mod=(int)(1e9+7);
    public int memo(int n,int k,int target,Integer[][][] dp){
        if(n==0){
            if(target==0){
                return dp[n][k][target]=1;
            }else return dp[n][k][target]=0;
        }
        
        if(dp[n][k][target]!=null)return dp[n][k][target];
        
        int ans=0;
        for(int i=1;i<=k;i++){
            if(target-i>=0){
                ans=(ans%mod+memo(n-1,k,target-i,dp)%mod)%mod;
            }
        }
        return dp[n][k][target]=ans%mod;
    }
}