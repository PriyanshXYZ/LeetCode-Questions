class Solution {
    public int uniquePathsIII(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int srcx=0,destx=0;
        int srcy=0,desty=0;
        int nonValid=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    srcx=i;
                    srcy=j;
                }
                if(grid[i][j]==2){
                    destx=i;
                    desty=j;
                }
                if(grid[i][j]==-1){
                    nonValid++;
                }
            }
        }
        boolean[][] visited=new boolean[n][m];
        int validCount=n*m-nonValid;
        return recursion(srcx,srcy,destx,desty,grid,visited,validCount);
    }
    public int recursion(int sRow,int sCol,int dRow,int dCol,int[][] grid,boolean[][] visited,int count){
        if(sRow==dRow && sCol==dCol && count<2)return 1;
        if(sRow>=grid.length || sCol>=grid[0].length || sRow<0 || sCol<0 || grid[sRow][sCol]==-1)return 0;
        
        int ans=0;
        visited[sRow][sCol]=true;
        //for up
        if(sRow>=1 && visited[sRow-1][sCol]==false)
            ans+=recursion(sRow-1,sCol,dRow,dCol,grid,visited,count-1);
        //for right
        if(sCol+1<grid[0].length && visited[sRow][sCol+1]==false)
            ans+=recursion(sRow,sCol+1,dRow,dCol,grid,visited,count-1);
        //for down
        if(sRow+1<grid.length && visited[sRow+1][sCol]==false)
            ans+=recursion(sRow+1,sCol,dRow,dCol,grid,visited,count-1);
        if(sCol>=1 && visited[sRow][sCol-1]==false)
            ans+=recursion(sRow,sCol-1,dRow,dCol,grid,visited,count-1);
        visited[sRow][sCol]=false;
        return ans;
    }
    
}