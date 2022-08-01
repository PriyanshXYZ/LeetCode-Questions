class Solution {
    int row;
    int col;
    public int uniquePaths(int m, int n) {
        row=m;
        col=n;
        int[][] dp=new int[m][n];
        
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return paths(0,0,dp);
    }
    public int paths(int r,int c,int[][] dp){
        if(r==row-1 && c==col-1)return 1;
        
        if(dp[r][c]!=-1)return dp[r][c];
        
        
        int ans=0;
        if(r+1<row){
            ans+=paths(r+1,c,dp);
        }
        if(c+1<col){
            ans+=paths(r,c+1,dp);
        }
        
        
        return dp[r][c]=ans;
    }
}