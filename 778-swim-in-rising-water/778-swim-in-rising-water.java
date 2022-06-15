class Solution {
    class Pair implements Comparable<Pair>{
        int r;
        int c;
        int tlsf;//time lapsed so far
        
        Pair(int r,int c,int tlsf){
            this.r=r;
            this.c=c;
            this.tlsf=tlsf;
        }
        @Override
        public int compareTo(Pair other){
            return this.tlsf-other.tlsf;
        }
    }
    
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        
        boolean[][] visited=new boolean[n][m];
        pq.add(new Pair(0,0,grid[0][0]));
        
        
        int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
        while(pq.size()!=0){
            Pair rPair=pq.remove();
            
            if(visited[rPair.r][rPair.c]==true){
                continue;
            }
            visited[rPair.r][rPair.c]=true;
            if(rPair.r==grid.length-1 && rPair.c==grid[0].length-1){
                return rPair.tlsf;
            }
            for(int i=0;i<4;i++){
                int nr=rPair.r+dir[i][0];
                int nc=rPair.c+dir[i][1];
                
                if(nr>=0 && nc>=0 && nr<n && nc<m && visited[nr][nc]==false){
                    
                    pq.add(new Pair(nr,nc,Math.max(rPair.tlsf,grid[nr][nc])));
                    
                }
            }
        }
        return -1;
    }
}