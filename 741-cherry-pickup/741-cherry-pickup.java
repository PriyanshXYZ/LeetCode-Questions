class Solution {
    public int cherryPickup(int[][] grid) {
        n=grid.length;
        return Math.max(0,f(0,0,0,grid,new Integer[grid.length][grid[0].length][grid[0].length]));
    }
    int n;
    public int f(int r1,int c1,int c2,int[][] grid,Integer[][][] dp){
        //out of bound case
        int r2=r1+c1-c2;
        if(r1>=n || c1>=n || c2>=n || r2>=n)return Integer.MIN_VALUE;
        if(grid[r1][c1]==-1 || grid[r2][c2]==-1)return Integer.MIN_VALUE;
        if(r1==n-1 && c1==n-1){
            return grid[r1][c1];
        }
        
        if(dp[r1][c1][c2]!=null){
            return dp[r1][c1][c2];
        }
        int max=Integer.MIN_VALUE;
        
        max=Math.max(max,f(r1+1,c1,c2+1,grid,dp));
        max=Math.max(max,f(r1+1,c1,c2,grid,dp));
        max=Math.max(max,f(r1,c1+1,c2+1,grid,dp));
        max=Math.max(max,f(r1,c1+1,c2,grid,dp));
        
        int res=0;
        if(max==Integer.MIN_VALUE){
            res=Integer.MIN_VALUE;
        }else{
            res=max;
            res+=grid[r1][c1];
            if(c1!=c2){
                res+=grid[r2][c2];
            }
        }
        return dp[r1][c1][c2]=res;
    }
}