class Solution {
    class Pair implements Comparable<Pair>{
        int x;
        int y;
        int obs;
        
        Pair(int x,int y ,int obs){
            this.x=x;
            this.y=y;
            this.obs=obs;
        }
        public int compareTo(Pair o){
            return this.obs-o.obs;
        }
    }
    public int minimumObstacles(int[][] grid) {
        PriorityQueue<Pair> q=new PriorityQueue();
        int[][] vis=new int[grid.length][grid[0].length];
        
        for(int i=0;i<vis.length;i++)Arrays.fill(vis[i],-1);
        int minObs=Integer.MAX_VALUE;
        q.add(new Pair(0,0,0));
        while(q.size()!=0){
            // System.out.println(q);
            Pair rem=q.remove();
            int x=rem.x;
            int y=rem.y;
            
            //invalid cell
            // if(x<0 || y<0 || x>=grid.length || y>=grid[0].length){
            //     continue;
            // }
            if(grid[x][y]==1){
                rem.obs+=1;
            }
            //we found our cell
            if(x==grid.length-1 && y==grid[0].length-1){
                minObs=Math.min(minObs,rem.obs);
            }
            
            if(vis[x][y]!=-1 && vis[x][y]<=rem.obs){
                continue;
            }
            vis[x][y]=rem.obs;
            
            //add neigbours to queue
            if(x+1<grid.length)
                q.add(new Pair(x+1,y,rem.obs));
            if(x>0)
                q.add(new Pair(x-1,y,rem.obs));
            if(y+1<grid[0].length)
                q.add(new Pair(x,y+1,rem.obs));
            if(y>0)
                q.add(new Pair(x,y-1,rem.obs));
        }
        return minObs;
    }
}