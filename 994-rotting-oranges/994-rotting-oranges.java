class Solution {
    public class Pair{
        int row;
        int col;
        int time;
        
        Pair(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
    
        Queue<Pair> q=new ArrayDeque();
        
        int freshCount=0;
        //adding initial rotten oranges
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(grid[r][c]==2){
                    q.add(new Pair(r,c,0));
                }else if(grid[r][c]==1){
                    freshCount++;
                }
            }
        }
        
        int time=0;
        int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
        while(q.size()>0){
            int size=q.size();
            
            while(size-- >0){
                Pair rPair=q.remove();
                
                for(int i=0;i<4;i++){
                    int nr=rPair.row+dir[i][0];
                    int nc=rPair.col+dir[i][1];
                    int t=rPair.time+1;
                    if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        freshCount--;
                        q.add(new Pair(nr,nc,t));
                    }
                }
            }
            if(!q.isEmpty() && q.peek().time>time){
                time=q.peek().time;
            }
        }
        if(freshCount==0){
            return time;
        }else {
            return -1;
        }
    }
}
class Solution1 {
    public class Pair{
        int row;
        int col;
        
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
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
        //we did time -1 because for the last layer if all the oranges were rotted then also the time was being incremented
        return time==0?0:time-1;
    }
    
    
}