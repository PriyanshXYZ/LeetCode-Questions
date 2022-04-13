class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> ans=new ArrayList();
        int m=mat.length,n=mat[0].length;
        int maxRow=m-1,maxCol=n-1;
        int minRow=0,minCol=0;
        
        int count=1;
        while(count<=m*n){
            //rightward
            for(int col=minCol;col<=maxCol && count<=m*n;col++){
                int row=minRow;
                ans.add(mat[row][col]);
                count++;
            }
            minRow=minRow+1;
            
            //downward
            for(int row=minRow;row<=maxRow && count<=m*n;row++){
                int col=maxCol;
                ans.add(mat[row][col]);
                count++;
            }
            maxCol=maxCol-1;
            
            //leftward
            for(int col=maxCol;col>=minCol && count<=m*n;col--){
                int row=maxRow;
                ans.add(mat[row][col]);
                count++;
            }
            maxRow=maxRow-1;
            
            //upwards
            for(int row=maxRow;row>=minRow && count<=m*n;row--){
                int col=minCol;
                ans.add(mat[row][col]);
                count++;
            }
            minCol=minCol+1;
        }
        return ans;
    }
}