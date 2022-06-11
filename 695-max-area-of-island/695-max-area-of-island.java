class Solution {
    int[][] grid;
    boolean[][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid=grid;
        int dr=grid.length,dc=grid[0].length;
        int currArea=0;
        visited=new boolean[dr][dc];
        for(int sr=0;sr<dr;sr++){
            for(int sc=0;sc<dc;sc++){
                if(grid[sr][sc]==1){
                    currArea=Math.max(helper(grid,sr,sc,dr,dc,visited),currArea);
                }
                visited[sr][sc]=true;
            }
        }
        return currArea;
    }
    public int helper(int[][] grid,int sr,int sc,int dr,int dc,boolean[][] visited){
        //base case
        if(sr<0 || sr>=dr || sc<0 || sc>=dc || visited[sr][sc] || grid[sr][sc]!=1) return 0;
        int area=0;        
        //faith 
        visited[sr][sc]=true;
        area+=helper(grid,sr-1,sc,dr,dc,visited);//up
        area+=helper(grid,sr,sc-1,dr,dc,visited);//left
        area+=helper(grid,sr+1,sc,dr,dc,visited);//down
        area+=helper(grid,sr,sc+1,dr,dc,visited);//right
        return area+1;
    }
}