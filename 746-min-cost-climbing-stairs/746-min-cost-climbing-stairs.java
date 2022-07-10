class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int x=cost[0],y=cost[1];
        for(int i=2;i<cost.length;i++){
            
            int z=Math.min(x,y)+cost[i];
            x=y;
            y=z;
        }
        return Math.min(x,y);
    }
    public int recursion(int idx,int[] cost){
        if(idx==cost.length)return 0;
        
        int ans=Integer.MAX_VALUE;
        if(idx+1<=cost.length){
            ans=Math.min(recursion(idx+1,cost),ans);
        }
        if(idx+2<=cost.length){
            ans=Math.min(recursion(idx+2,cost),ans);
        }
        ans+=cost[idx];
        return ans;
    }
    public int memo(int idx,int[] cost,int[] dp){
        if(idx==cost.length)return 0;
        
        if(dp[idx]!=Integer.MAX_VALUE);
        
        int ans=Integer.MAX_VALUE;
        if(idx+1<=cost.length){
            ans=Math.min(memo(idx+1,cost,dp),ans);
        }
        if(idx+2<=cost.length){
            ans=Math.min(memo(idx+2,cost,dp),ans);
        }
        ans+=cost[idx];
        return dp[idx]=ans;
    }
    
}