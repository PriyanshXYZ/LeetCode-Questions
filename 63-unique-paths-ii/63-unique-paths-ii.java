class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        // boolean[][] visited=new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0 && grid[0][0]!=1){
                    dp[i][j]=1;
                    continue;
                }
                int ans=0;
                if(i>=1 && grid[i-1][j]!=1){
                    ans+=dp[i-1][j];
                }
                if(j>=1 && grid[i][j-1]!=1){
                    ans+=dp[i][j-1];
                }
                dp[i][j]=ans;
            }
        }
        return grid[n-1][m-1]==1?0:dp[n-1][m-1];
    }
    public int recursion(int n,int m,int[][] grid,boolean[][] visited){
        if(m<0 || n<0 || grid[n][m]==1 )return 0; 
        
        if(m==0 &&n==0)return 1;
        int ans=0;
        visited[n][m]=true;
        if(n>=1 && !visited[n-1][m]){
            ans+=recursion(n-1,m,grid,visited);
        }
        if(m>=1 && !visited[n][m-1]){
            ans+=recursion(n,m-1,grid,visited);
        }
        visited[n][m]=false;
        
        return ans;
    }
    
    public int memo(int n,int m,int[][] grid,boolean[][] visited,int[][] dp){
        if(m<0 || n<0 || grid[n][m]==1 )return dp[n][m]=0; 
        
        if(m==0 &&n==0)return dp[n][m]=1;
        
        if(dp[n][m]!=0)return dp[n][m];
        int ans=0;
        visited[n][m]=true;
        if(n>=1 && !visited[n-1][m]){
            ans+=memo(n-1,m,grid,visited,dp);
        }
        if(m>=1 && !visited[n][m-1]){
            ans+=memo(n,m-1,grid,visited,dp);
        }
        visited[n][m]=false;
        
        return dp[n][m]=ans;
    }
}