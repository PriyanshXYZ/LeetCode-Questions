class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        // return recursion(n - 1, m - 1, grid);
        int[][] dp=new int[n][m];
        return memo(n - 1, m - 1, grid, dp);
        //tabulation
        
    }
    public int recursion(int n, int m, int[][] grid){
        //base case
        if(n < 0 || m < 0 || grid[n][m]==1)return 0;
        if(n==0 && m==0)return 1;
        int ans = recursion(n - 1, m,grid) + recursion(n, m - 1, grid);
        return ans;
    }
    
    public int memo(int n, int m, int[][] grid, int[][] dp){
        if(n < 0 || m < 0 || grid[n][m] == 1)return 0;
        if(n == 0 && m == 0)return dp[n][m] = 1;
        
        if(dp[n][m] !=0)return dp[n][m];
        
        int ans = memo(n - 1, m,grid, dp) + memo(n, m - 1, grid, dp);
        return dp[n][m] = ans;
    }
}