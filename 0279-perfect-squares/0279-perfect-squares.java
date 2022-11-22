class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return recursion(n,dp);
    }
    public int recursion(int n,int[] dp){
        if(n==0)return 0;
        if(dp[n]!=-1)return dp[n];
        
        int ans=Integer.MAX_VALUE;
        for(int i=(int)Math.pow(n,0.5);i>0;i--){
            
            ans=Math.min(ans,1+recursion(n-i*i,dp));
        }
        
        return dp[n]=ans;
    }
}