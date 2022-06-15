class Solution {
    class Pair{
        int row;
        int col;
        int dist;
        
        Pair(int row,int col,int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        Queue<Pair> q=new ArrayDeque();
        
        boolean[][] vis=new boolean[n][m];
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(mat[r][c]==0){
                    vis[r][c]=true;
                    q.add(new Pair(r,c,0));
                }
            }
        }
        
        int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
        while(q.size()!=0){
            int size=q.size();
            while(size-- >0){
                Pair rPair=q.remove();
                for(int i=0;i<4;i++){
                    int nr=rPair.row+dir[i][0];
                    int nc=rPair.col+dir[i][1];
                    int dist=rPair.dist+1;

                    if(nr>=0 && nc>=0 && nr<n && nc<m && vis[nr][nc]==false){
                        mat[nr][nc]=dist;
                        q.add(new Pair(nr,nc,dist));
                        vis[nr][nc]=true;
                    }
                }
            }
        }
        return mat;
    }
}