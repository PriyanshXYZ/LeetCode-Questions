class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat=new int[n][n];
        int maxRow=n-1,maxCol=n-1;
        int minRow=0,minCol=0;
        
        int num=1;
        while(num<=n*n){
            //rightward
            for(int col=minCol;col<=maxCol;col++){
                int row=minRow;
                mat[row][col]=num;
                num++;
            }
            minRow=minRow+1;
            
            //downward
            for(int row=minRow;row<=maxRow;row++){
                int col=maxCol;
                mat[row][col]=num;
                num++;
            }
            maxCol=maxCol-1;
            
            //leftward
            for(int col=maxCol;col>=minCol;col--){
                int row=maxRow;
                mat[row][col]=num;
                num++;
            }
            maxRow=maxRow-1;
            
            //upwards
            for(int row=maxRow;row>=minRow;row--){
                int col=minCol;
                mat[row][col]=num;
                num++;
            }
            minCol=minCol+1;
        }
        return mat;
    }
}