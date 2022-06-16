class Solution {
    class Pair{
        int r;
        int c;
        int dist;
        
        Pair(int r,int c,int dist){
            this.r=r;
            this.c=c;
            this.dist=dist;
        }
    }
    public int shortestBridge(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> q=new ArrayDeque();
        
        boolean found=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    getConnected(grid,i,j,q,new boolean[n][m]);
                    found=true;
                    break;
                }
            }
            if(found)break;
        }
        
        boolean[][] vis=new boolean[n][m];
        
        int minDist=Integer.MAX_VALUE;
        
        while(q.size()!=0){
            int size=q.size();
            while(size-- >0){
                Pair rPair=q.remove();
                if(grid[rPair.r][rPair.c]==1){
                    return rPair.dist-1;
                }
                for(int i=0;i<4;i++){
                    int nr=rPair.r+dir[i][0];
                    int nc=rPair.c+dir[i][1];
                    int d=rPair.dist+1;
                    if(nr>=0 && nc>=0 && nr<n && nc<m && vis[nr][nc]==false ){
                        q.add(new Pair(nr,nc,d));
                        vis[nr][nc]=true;
                    }
                }
            }
        }
        return -1;
    }
    int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
    public void getConnected(int[][] grid,int r,int c,Queue<Pair> q,boolean[][] vis){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==0 || vis[r][c]==true)return;
        
        vis[r][c]=true;
        q.add(new Pair(r,c,0));
        for(int i=0;i<4;i++){
            getConnected(grid,r+dir[i][0],c+dir[i][1],q,vis);
        }
        grid[r][c]=2;
    }
}