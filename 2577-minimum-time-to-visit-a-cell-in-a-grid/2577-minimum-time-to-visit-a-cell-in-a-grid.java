class Solution {
    class Pair{
        int r;
        int c;
        int time;
        Pair(int r, int c, int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
    public int minimumTime(int[][] grid) {
        if(grid[0][1]>1 &&  grid[1][0]>1)return -1;
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->a.time-b.time);
        
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        q.add(new Pair(0,0,0));
        vis[0][0]=true;
        while(q.size()>0){
            int size = q.size();
            while(size-- > 0){
                Pair rem = q.remove();
                
                int r=rem.r;
                int c=rem.c;
                if(r==grid.length-1 && c==grid[0].length-1)return rem.time;
                for(int[] dir : dirs){
                    int x = r + dir[0];
                    int y = c + dir[1];
                    if(x<0 || y<0 || y>=grid[0].length || x>=grid.length || vis[x][y]==true)continue;
                    if(rem.time+1>=grid[x][y]){
                        q.add(new Pair(x,y,rem.time+1));
                        vis[x][y]=true;
                    }else{
                        int dist = (grid[x][y]-rem.time);
                        if(dist%2==1)
                            q.add(new Pair(x,y,rem.time + dist));
                        else
                            q.add(new Pair(x,y,rem.time + dist + 1));
                        vis[x][y]=true;
                    }
                }
            }

        }
        return -1;
    }
}