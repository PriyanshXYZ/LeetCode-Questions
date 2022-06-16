class Solution {
    class Pair{
        int r;
        int c;
        Pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
    
    int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
    
    
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int prevColor=grid[row][col];
        
        int n=grid.length;
        int m=grid[0].length;
        
        Queue<Pair> q=new ArrayDeque();
        
        boolean[][] vis=new boolean[n][m];
        
        ArrayList<Pair> border=new ArrayList();
        //adding required component
        q.add(new Pair(row,col));
        vis[row][col]=true;
        
        while(q.size()!=0){
            int size=q.size();
            while(size-- >0){
                Pair rPair=q.remove();
                if(isBorder(grid,rPair.r,rPair.c,prevColor)){
                    border.add(rPair);
                }
                
                for(int i=0;i<4;i++){
                    int nr=rPair.r+dir[i][0];
                    int nc=rPair.c+dir[i][1];
                    
                    if(nr>=0 && nc>=0 && nr<n && nc<m && vis[nr][nc]==false && grid[nr][nc]==prevColor){
                        q.add(new Pair(nr,nc));
                        vis[nr][nc]=true;
                    }
                }
            }
        }
        for(Pair p:border){
            grid[p.r][p.c]=color;
        }
        return grid;
    }
    
    public boolean isBorder(int[][] grid,int i,int j,int color){
        if(i==0 || j==0 || j==grid[0].length-1 || i==grid.length-1){
            return true;
        }
        if(grid[i-1][j]!=color){
            return true;
        }else if(grid[i+1][j]!=color){
            return true;
        }else if(grid[i][j-1]!=color){
            return true;
        }else if(grid[i][j+1]!=color){
            return true;
        }else{
            return false;
        }
        
    }
}