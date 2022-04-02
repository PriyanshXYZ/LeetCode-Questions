class Solution {
    public int[] postFix(int[][] grid,int n,int m){
        int[] res=new int[m];
        res[m-1]=grid[n-1][m-1];
        for(int col=m-2;col>=0;col--){
            res[col]=res[col+1]+grid[n-1][col];
        }
        return res;
    }
    public int minPathSum(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        // return recursion(0,0,n,m,grid);
        // int[][] dp=new int[n][m];
        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return memo(0,0,n,m,grid,dp);
        int[] dp=postFix(grid,n,m);
        return optimized(0,0,n,m,grid,dp);
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
    //using memoization we have optimized the call by storing it in the memory
    //time complexity O(N^2) and Space Complexity O(N^2)
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
    //further space optimization is possible in this question
    //this can be done by storing last row array with postFix sum
    //such that we will minimum cost for the last row
    public int optimized(int r,int c,int n,int m,int[][] cost,int[] dp){
        for(int row=n-2;row>=0;row--){
            for(int col=m-1;col>=0;col--){
                int ans=Integer.MAX_VALUE;
                if(row+1<=n-1){
                    ans=Math.min(ans,dp[col]);
                }
                if(col+1<=m-1){
                    ans=Math.min(ans,dp[col+1]);
                }
                dp[col]=ans+ cost[row][col];
            }
        }
        return dp[0];
    }
}