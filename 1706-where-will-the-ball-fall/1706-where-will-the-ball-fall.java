class Solution {
    public int[] findBall(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[] ans=new int[m];
        for(int j=0;j<m;j++){
            ans[j]=dfs(0,j,grid);
        }
        return ans;
    }
    
    public int dfs(int r,int c,int[][] grid){
        //base case
        if(r==grid.length){
            // System.out.println("exited at "+c);
            return c;
        }
        
        if(grid[r][c]==1){
           if(c+1<grid[0].length && grid[r][c+1]==1){
               //move right
               // System.out.println("going"+(r+1)+" "+(c+1));
               return dfs(r+1,c+1,grid);
           }else{
               //blockage
               // System.out.println("blockage at "+r+" "+c);
               return -1;
           }
        }else{
            if(c-1>=0 && grid[r][c-1]==-1){
                //move left
                // System.out.println("going"+(r+1)+" "+(c-1));
                return dfs(r+1,c-1,grid);
            }else{
                //blockage
                // System.out.println("blockage at "+r+" "+c);
                return -1;
            }
        }
    }
}