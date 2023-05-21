class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        
        boolean isFound = false;
        Queue<int[]> q = new ArrayDeque<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    getConnectedComponents(i,j,grid,vis,q);
                    isFound=true;
                    break;
                }
            }
            if(isFound)break;
        }
        
        int steps=0;
        while(q.size()>0){
            int size = q.size();
            while(size-- > 0){
                int[] rem = q.remove();
                int i = rem[0],j=rem[1];

                if(grid[i][j]==1)return steps-1;
                
                for(int[] dir : dirs){
                    int r = i + dir[0];
                    int c = j + dir[1];
                    if(r>=0 && c>=0 && r<n && c<m && vis[r][c]==false){
                        q.add(new int[]{r,c});
                        vis[r][c]=true;
                    }
                        
                }    
            }
            steps++;
            
        }
        return -1;
    }
    int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    public void getConnectedComponents(int i, int j, int[][] grid, boolean[][] vis,Queue<int[]> q){
        //base
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length  || grid[i][j]==0 || vis[i][j])return;
        
        vis[i][j] = true;
        
        for(int[] dir : dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;
            getConnectedComponents(r,c,grid,vis,q);
            
        }
        q.add(new int[]{i,j});
        grid[i][j] = 2;
    }
}