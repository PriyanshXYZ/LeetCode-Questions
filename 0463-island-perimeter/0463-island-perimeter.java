class Solution {

    public int islandPerimeter(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        int nbr=0;
        for(int i=0;i<n;i++){
            int maxgrid=4;
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    ans+=4;
                    nbr+=neighbour(grid,i,j);
                }
            }
        }
        return ans-nbr*2;
    }
    int[][] dirs={{0,1},{1,0}};
    int neighbour(int[][] a,int i,int j){
        int count=0;
        for(int[] dir:dirs){
            int r=dir[0]+i;
            int c=dir[1]+j;
            if(r>=0 && c>=0 && r<a.length && c<a[0].length){
                if(a[r][c]==1){
                    count+=1;
                }
            }
        }
        return count;
    }
}