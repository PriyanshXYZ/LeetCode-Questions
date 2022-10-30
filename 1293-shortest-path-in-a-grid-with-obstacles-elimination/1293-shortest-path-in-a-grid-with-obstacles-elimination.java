class Solution {
    class Pair{
        int x;
        int y;
        int len;
        int r;
        
        Pair(int x,int y,int len,int r){
            this.x=x;
            this.y=y;
            this.len=len;
            this.r=r;
        }
    }
    public int shortestPath(int[][] grid, int k) {
        Queue<Pair> q=new ArrayDeque();
        int[][] vis=new int[grid.length][grid[0].length];
        for(int i=0;i<vis.length;i++){
            Arrays.fill(vis[i],-1);
        }
        q.add(new Pair(0,0,0,k));
        while(!q.isEmpty()){
            //get pair
            Pair rPair=q.remove();
            int x=rPair.x;
            int y=rPair.y;
            if(x<0 || y<0 || x>=grid.length || y>=grid[0].length){
                continue;
            }
            
            if(grid[x][y]==1){
                if(rPair.r>0){
                    rPair.r-=1;
                }else{
                    continue;
                }
            }
            
            if(rPair.x==grid.length-1 && rPair.y==grid[0].length-1){
                return rPair.len;
            }
            
            //more obstacles removed must be preferred
            if(vis[rPair.x][rPair.y]!=-1 && vis[rPair.x][rPair.y]>=rPair.r){
                continue;
            }
            vis[rPair.x][rPair.y]=rPair.r;
            
            q.add(new Pair(rPair.x+1,rPair.y,rPair.len+1,rPair.r));
            q.add(new Pair(rPair.x-1,rPair.y,rPair.len+1,rPair.r));
            q.add(new Pair(rPair.x,rPair.y+1,rPair.len+1,rPair.r));
            q.add(new Pair(rPair.x,rPair.y-1,rPair.len+1,rPair.r));
        }
        return -1;
    }
}