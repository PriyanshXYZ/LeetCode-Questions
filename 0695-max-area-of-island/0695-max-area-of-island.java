class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1)
                ans = Math.max(ans, dfs(i,j,grid));
            }
        }
        return ans;
    }

    public int dfs(int r, int c, int[][] grid) {
        //base case
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==0)return 0;
        grid[r][c] = 0;
        return 1+dfs(r+1, c, grid)+
        dfs(r-1, c, grid)+
        dfs(r, c+1, grid)+
        dfs(r, c-1, grid);
    }
}