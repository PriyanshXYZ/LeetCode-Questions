class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}, {1,1}, {-1,1}, {1,-1}, {-1,-1}};
        
        if(grid == null || grid.length == 0) return -1;
        
        if(grid[0][0] != 0) return -1;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0,0,0});
        
        while(!queue.isEmpty()){
            
            int[] curr = queue.poll();
            if(curr[0] == grid.length-1 && curr[1] == grid[0].length-1) return curr[2]+1;
            
            
            for(int i=0; i < dirs.length; i++){
                int x = curr[0] + dirs[i][0];
                int y = curr[1] + dirs[i][1];
                
                if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 0) continue;
                
                grid[x][y] = -1;
                queue.add(new int[]{x,y, curr[2]+1});
            }
        }
        
        return -1;
    }
    
    static class My{
    int[][] dir={{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        boolean[][] visit=new boolean[n][m];
        
        return recursion(0,0,n,m,grid,visit);
    }
    public int recursion(int r,int c,int n,int m,int[][] grid,boolean[][] visit){
        if(r==n-1 && c==m-1)return 1;
        
        if(r<0 || c<0 || r>=n || c>=m || grid[r][c]==1 || visit[r][c])return Integer.MAX_VALUE;
        visit[r][c]=true;
        int ans=0;
        //8 directions possible
        for(int[] d:dir){
            ans=Math.min(ans,recursion(r+d[0],c+d[1],n,m,grid,visit));
        }
        visit[r][c]=false;
        
        if(ans==Integer.MAX_VALUE)return -1;
        return ans+1;
    }
    }
}