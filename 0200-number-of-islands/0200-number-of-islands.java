class Solution {
    class UF{
        private int components;
        private int[] parent;
        private int[] size;

        UF(int n){
            components = n;
            parent = new int[n];
            size = new int[n];

            for(int i=0;i<n;i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        
        public int find(int x){
            if(parent[x] == x)return x;
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y){
            int xLead = find(x);
            int yLead = find(y);

            if(xLead == yLead){
                //alreaady a union
            }else {
                if(size[xLead]>size[yLead]){
                    size[xLead] += size[yLead];
                    parent[yLead] = xLead;
                }else {
                    size[yLead] += size[xLead];
                    parent[xLead] = yLead;
                }
                components--;
            }
        }

        public int getComponents(){
            return components;
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j] == false && grid[i][j] == '1'){
                    ans++;
                    dfs(i,j,grid,vis);
                }
            }
        }
        return ans;
    }
    
    public void dfs(int r, int c, char[][] grid, boolean[][] vis) {
        //base case
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || vis[r][c] || grid[r][c]=='0')return;
        vis[r][c] = true;
        dfs(r+1, c, grid, vis);
        dfs(r-1, c, grid, vis);
        dfs(r, c+1, grid, vis);
        dfs(r, c-1, grid, vis);
    }
}