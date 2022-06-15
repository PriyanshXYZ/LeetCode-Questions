class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
    
        Queue<Pair> q=new ArrayDeque();
        
        //adding initial rotten oranges
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(grid[r][c]==2){
                    q.add(new Pair(r,c));
                }
            }
        }
        
        int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
        int time=0;
        //applying bfs
        while(q.size()!=0){
            int size=q.size();
            
            while(size-- >0){
                Pair rPair=q.remove();
                
                for(int i=0;i<4;i++){
                    int nr=rPair.row+dir[i][0];
                    int nc=rPair.col+dir[i][1];
                    
                    if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        q.add(new Pair(nr,nc));
                    }
                }
            }
            time++;
        }
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(grid[r][c]==1){
                    return -1;
                }
            }
        }
        return time==0?0:time-1;
    }
    
    public class Pair{
        int row;
        int col;
        
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
}