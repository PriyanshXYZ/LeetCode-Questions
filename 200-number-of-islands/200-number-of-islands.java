class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    recursion(grid,i,j);
                    count++;
                }
            }
        }
        return count;
        
    }
    int[] dx={-1,0,1,0};
    int[] dy={0,1,0,-1};
       
    public void recursion(char[][] mat,int r,int c){
          //out of bound
         if(mat[r][c]=='0')return;
        
         mat[r][c]='0';
         for(int i=0;i<4;i++){
            int px=r+dx[i];
            int py=c+dy[i];
            if(px>=0 && py>=0 && px<mat.length && py<mat[0].length && mat[px][py]=='1'){
                recursion(mat,px,py);  
            }
        }
    }
}