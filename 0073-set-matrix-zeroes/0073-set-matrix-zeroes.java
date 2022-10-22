class Solution {
    class Pair{
        int x;
        int y;
        
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public void setZeroes(int[][] matrix) {
        List<Pair> zeros=new ArrayList();
        int n=matrix.length;
        int m=matrix[0].length;
        //getting zeros
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    Pair p=new Pair(i,j);
                    zeros.add(p);
                }
            }
        }
        if(zeros.size()==m*n)return;
        for(Pair p:zeros){
            int r=p.x;
            int c=p.y;
            
            for(int i=0;i<n;i++){
                matrix[i][c]=0;
            }
            for(int j=0;j<m;j++){
                matrix[r][j]=0;
            }
        }
    }
}