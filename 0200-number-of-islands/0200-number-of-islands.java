class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1' && vis[i][j]==false){
                    dfs(i, j, vis, grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public void dfs(int r, int c, boolean[][] vis, char[][] grid) {
        vis[r][c] = true;
        for(int[] dir : dirs){
            int x = dir[0] + r;
            int y = dir[1] + c;
            if(x>=grid.length || y>=grid[0].length || x<0 || y<0 || vis[x][y] || grid[x][y]=='0')continue;
            dfs(x, y, vis, grid);
        }
    }
}