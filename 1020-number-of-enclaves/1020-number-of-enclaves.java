class Solution {
    boolean flag;
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==false){
                    flag=true;
                    int comps=dfs(grid,i,j,vis);
                    if(flag)count+=comps;
                }
            }
        }
        return count;
    }
    
    public int dfs(int[][] grid,int r,int c,boolean[][] vis){
        //base case
        
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length){
            flag=false;
            return 0;
        }
        if(grid[r][c]==0 || vis[r][c]==true)return 0;
        vis[r][c]=true;
        int ans=0;
        ans+=dfs(grid,r+1,c,vis);
        ans+=dfs(grid,r-1,c,vis);
        ans+=dfs(grid,r,c+1,vis);
        ans+=dfs(grid,r,c-1,vis);
        return ans+1;
    }
}