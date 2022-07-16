class Solution {
    int[][] dirs={{-1,0},{0,1},{1,0},{0,-1}};
    // O(m*n*maxMoves) time and space
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp=new int[m+1][n+1][maxMove+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                Arrays.fill(dp[i][j],-1);        
            }
        }
        
        return memo(m,n,maxMove,startRow,startColumn,dp);
    }
    int mod=(int)1e9+7;
    public int memo(int m,int n,int maxMove,int row,int col,int[][][] dp){
        if(row<0 || row==m || col<0 || col==n)return 1;
        if(maxMove==0)return 0;
        if(dp[row][col][maxMove]>=0)return dp[row][col][maxMove];
        int ans=0;
        for(int[] dir:dirs){
            int x=row+dir[0];
            int y=col+dir[1];
            
            ans=(ans%mod+memo(m,n,maxMove-1,x,y,dp)%mod)%mod;
        }
        return dp[row][col][maxMove]=ans;
    }
}
class Solution1 {
    //recursion 4^maxMove
    int[][] dirs={{-1,0},{0,1},{1,0},{0,-1}};
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        if((startRow<0 || startRow>=m || startColumn<0 || startColumn>=n)&& maxMove>=0)return 1;
        if(maxMove<0)return 0;
        int ans=0;
        for(int[] dir:dirs){
            int x=startRow+dir[0];
            int y=startColumn+dir[1];
            
            ans+=findPaths(m,n,maxMove-1,x,y);
        }
        return ans;
    }
}