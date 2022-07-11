class Solution {
    int n;
    int m;
    
    public int[] hitBricks(int[][] grid, int[][] hits) {
        n=grid.length;
        m=grid[0].length;
        
        parent=new int[m*n+1];
        rank =new int[m*n+1];
        size=new int[m*n+1];
        
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
            size[i]=1;
        }
        
        //setting valid hits as 2 ...
        for(int[] hit:hits){
            int x=hit[0];
            int y=hit[1];
            
            if(grid[x][y]==1){
                grid[x][y]=2;
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    unionHelper(grid,i,j);
                }
            }
        }
        int[] res=new int[hits.length];
        for(int i=hits.length-1;i>=0;i--){
            int x=hits[i][0];
            int y=hits[i][1];
            
            if(grid[x][y]==2){
                
                int connectedbrickNo=size[find(0)];
                
                grid[x][y]=1;
                unionHelper(grid,x,y);

                int newConnectedBrickNo=size[find(0)];
                
                if(newConnectedBrickNo>connectedbrickNo){
                    res[i]=newConnectedBrickNo-connectedbrickNo-1;//-1 due to adding hit brick in the components as well
                }
            }
        }
        return res;
    }
    int[] parent;
    int[] rank;
    int[] size;

    int[][] dirs={{-1,0},{0,1},{1,0},{0,-1}};
    
    public void unionHelper(int[][] grid,int x,int y){
        int brickNo=x*m+y+1;//values of idx when x and y are converted into 1d array ..
        
        for(int[] dir:dirs){
            int dx=x+dir[0];
            int dy=y+dir[1];
            
            if(dx>=0 && dx<n && dy>=0 && dy<m && grid[dx][dy]==1){
                int otherBrickNo=dx*m+dy+1;//values of idx when x and y are converted into 1d array ..
                union(brickNo,otherBrickNo);    
            }
        }
        if(x==0){
            union(0,brickNo);
        }
    }
    
    public int find(int x){
        if(parent[x]==x){
            return x;
        }else{
            parent[x]=find(parent[x]);
            return parent[x];
        }
    }
    
    public void union(int x,int y){
        int xlead=find(x);
        int ylead=find(y);
        
        if(xlead!=ylead){
            if(rank[xlead]>rank[ylead]){
                parent[ylead]=xlead;
                size[xlead]+=size[ylead];
            }else if(rank[xlead]<rank[ylead]){
                parent[xlead]=ylead;
                size[ylead]+=size[xlead];
            }else{
                parent[xlead]=ylead;
                size[ylead]+=size[xlead];
            }
        }
    }
        
}