class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dp=new int[m][n];
        // return memo(m-1,n-1,dp);
        dp[m-1][n-1] = 1;
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >=0; j--){
                if(i==m-1 || j==n-1){
                    dp[i][j]=1;
                    continue;
                }
                dp[i][j]= dp[i][j+1] + dp[i+1][j];
            }
        }
        return dp[0][0];
    }
    public int recursion(int m,int n){
        if(m==0 &&n==0)return 1;
        if(m<0 || n<0)return 0;
        int ans=0;
        
        if(m>=1 ){
            ans+=recursion(m-1,n);    
        }
        if(n>=1 ){
            ans+=recursion(m,n-1);
        }
        return ans;
    }
    public int memo(int m,int n,Integer[][] dp){
        if(m<0 || n<0)return 0;
        if(m==0 &&n==0)return dp[m][n]=1;
        
        if(dp[m][n]!=null)return dp[m][n];
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