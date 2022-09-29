class Solution {
    public int cherryPickup(int[][] grid) {
        Integer[][][] dp=new Integer[grid.length][grid[0].length][grid[0].length];
        // return recursion(0,0,0,grid[0].length-1,grid);
        return memo(0,0,grid[0].length-1,grid,dp);
    }
    public int recursion(int r1, int c1, int r2, int c2, int[][] grid){
        //out of bound cases
        if(r1>=grid.length || r2>=grid.length || c1>=grid[0].length || c2>=grid[0].length || c2<0 || c1<0){
            return 0;
        }
        //remember the property of r1 + c1 = r2 + c2
        
        int ans=Integer.MIN_VALUE;
        
        ans=Math.max(ans,recursion(r1+1,c1+1,r2+1,c2+1,grid));
        ans=Math.max(ans,recursion(r1+1,c1+1,r2+1,c2,grid));
        ans=Math.max(ans,recursion(r1+1,c1+1,r2+1,c2-1,grid));
        
        ans=Math.max(ans,recursion(r1+1,c1,r2+1,c2+1,grid));
        ans=Math.max(ans,recursion(r1+1,c1,r2+1,c2,grid));
        ans=Math.max(ans,recursion(r1+1,c1,r2+1,c2-1,grid));
        
        ans=Math.max(ans,recursion(r1+1,c1-1,r2+1,c2+1,grid));
        ans=Math.max(ans,recursion(r1+1,c1-1,r2+1,c2,grid));
        ans=Math.max(ans,recursion(r1+1,c1-1,r2+1,c2-1,grid));
        
        
        int res=ans;
        res+=grid[r1][c1];
        if(c1!=c2){
            res+=grid[r2][c2];
        }
        return res;
    }
    
    //r2 can be calculated using rest of 3 parameters
    public int memo(int r1, int c1, int c2, int[][] grid,Integer[][][] dp){
        int r2=r1;
        //out of bound cases
        if(r1>=grid.length || r2>=grid.length || c1>=grid[0].length || c2>=grid[0].length || c2<0 || c1<0){
            return 0;
        }
        //remember the property of r1 + c1 = r2 + c2
        if(dp[r1][c1][c2]!=null)return dp[r1][c1][c2];
        
        int ans=Integer.MIN_VALUE;
        
        ans=Math.max(ans,memo(r1+1,c1+1,c2+1,grid,dp));
        ans=Math.max(ans,memo(r1+1,c1+1,c2,grid,dp));
        ans=Math.max(ans,memo(r1+1,c1+1,c2-1,grid,dp));
        
        ans=Math.max(ans,memo(r1+1,c1,c2+1,grid,dp));
        ans=Math.max(ans,memo(r1+1,c1,c2,grid,dp));
        ans=Math.max(ans,memo(r1+1,c1,c2-1,grid,dp));
        
        ans=Math.max(ans,memo(r1+1,c1-1,c2+1,grid,dp));
        ans=Math.max(ans,memo(r1+1,c1-1,c2,grid,dp));
        ans=Math.max(ans,memo(r1+1,c1-1,c2-1,grid,dp));
        
        
        int res=ans;
        res+=grid[r1][c1];
        if(c1!=c2){
            res+=grid[r2][c2];
        }
        return dp[r1][c1][c2]=res;
    }
}