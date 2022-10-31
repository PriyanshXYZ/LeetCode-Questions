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
    int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    public int minimumObstacles(int[][] grid) {
        PriorityQueue<Pair> q=new PriorityQueue();
        int[][] vis=new int[grid.length][grid[0].length];
        
        for(int i=0;i<vis.length;i++)Arrays.fill(vis[i],Integer.MAX_VALUE);
        
        q.add(new Pair(0,0,0));
        vis[0][0]=grid[0][0];
        while(q.size()!=0){
            Pair rem=q.remove();
            int x=rem.x;
            int y=rem.y;
        
            //we found our cell
            if(x==grid.length-1 && y==grid[0].length-1){
                return rem.obs;
            }
            
            //add neigbours to queue
            for(int[] dir:dirs){
                int xx=x+dir[0];
                int yy=y+dir[1];
                // invalid cell
                if(xx<0 || yy<0 || xx>=grid.length || yy>=grid[0].length){
                    continue;
                }
                
                if(rem.obs+grid[xx][yy]<vis[xx][yy]){
                        
                    q.add(new Pair(xx,yy,rem.obs+grid[xx][yy]));
                    vis[xx][yy]=rem.obs+grid[xx][yy];
                }
                
            }
        }
        return -1;
    }
}