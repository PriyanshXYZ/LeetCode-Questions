class Solution {
    int mod=(int)(Math.pow(10,9)+7);
    public int countPaths(int[][] grid) {
        long[][] dp=new long[1001][1001];
        long res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                res+=recursion(grid,i,j,dp);
                res=res%mod;
            }
        }
        return (int)res;
    }
    
    
    int[][] dirs={{-1,0},{0,1},{1,0},{0,-1}};
    public long recursion(int[][] grid,int r,int c,long[][] dp){
        
        
        if(dp[r][c]!=0)return dp[r][c];
        long ans=1;
        for(int[] dir:dirs){
            int x=r+dir[0];
            int y=c+dir[1];
            if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[r][c]<grid[x][y])
                ans+=recursion(grid,x,y,dp)%mod;
        }
        return dp[r][c]=ans%mod;
    }
}