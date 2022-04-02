class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return memo(0,0,n,m,grid,dp);
    }
    //time limit excedded in recursion due to Time complexity O(2^n)
    public int recursion(int r,int c,int n,int m,int[][] cost){
        if(r==n-1 && c==m-1){
            return cost[r][c];
        }
        int ans=Integer.MAX_VALUE;
        if(r+1<=n-1){
            ans=Math.min(ans,recursion(r+1,c,n,m,cost));
        }
        if(c+1<=m-1){
            ans=Math.min(ans,recursion(r,c+1,n,m,cost));
        }
        return ans+cost[r][c];
    }
    //accepted solution
    //using memoizartion
    public int memo(int r,int c,int n,int m,int[][] cost,int[][] dp){
        if(r==n-1 && c==m-1){
            return dp[r][c]=cost[r][c];
        }
        if(dp[r][c]!=-1){
            return dp[r][c]; //this will return value of already computed in recursion
        }
        int ans=Integer.MAX_VALUE;
        if(r+1<=n-1){
            ans=Math.min(ans,memo(r+1,c,n,m,cost,dp));
        }
        if(c+1<=m-1){
            ans=Math.min(ans,memo(r,c+1,n,m,cost,dp));
        }
        return dp[r][c]=ans+cost[r][c];
    }
}