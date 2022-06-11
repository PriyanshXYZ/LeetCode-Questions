class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int dr=grid.length,dc=grid[0].length;
        int currArea=0;
        for(int sr=0;sr<dr;sr++){
            for(int sc=0;sc<dc;sc++){
                if(grid[sr][sc]==1){
                    currArea=Math.max(helper(grid,sr,sc,dr,dc),currArea);
                }
            }
        }
        return currArea;
    }
    public int helper(int[][] grid,int sr,int sc,int dr,int dc){
        //base case
        if(sr<0 || sr>=dr || sc<0 || sc>=dc || grid[sr][sc]!=1) return 0;
        int area=0;        
        //faith 
        grid[sr][sc]=0;
        area+=helper(grid,sr-1,sc,dr,dc);//up
        area+=helper(grid,sr,sc-1,dr,dc);//left
        area+=helper(grid,sr+1,sc,dr,dc);//down
        area+=helper(grid,sr,sc+1,dr,dc);//right
        return area+1;
    }
}