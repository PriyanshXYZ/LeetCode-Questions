class Solution {
    public int uniquePaths(int m, int n) {
        boolean[][] visited=new boolean[m][n];
        int[][] dp=new int[m][n];
        return memo(m-1,n-1,dp);
    }
    public int recursion(int m,int n,boolean[][] visited){
        if(m==0 &&n==0)return 1;
        if(m<0 || n<0)return 0;
        int ans=0;
        visited[m][n]=true;
        if(m>=1 && !visited[m-1][n]){
            ans+=recursion(m-1,n,visited);    
        }
        if(n>=1 && !visited[m][n-1]){
            ans+=recursion(m,n-1,visited);
        }
        visited[m][n]=false;
        
        return ans;
    }
    public int memo(int m,int n,int[][] dp){
        if(m==0 &&n==0)return dp[m][n]=1;
        if(m<0 || n<0)return dp[m][n]=0;
        if(dp[m][n]!=0)return dp[m][n];
        int ans=0;
        
        if(m>=1){
            ans+=memo(m-1,n,dp);    
        }
        if(n>=1){
            ans+=memo(m,n-1,dp);
        }
        
        
        return dp[m][n]=ans;
    }
}