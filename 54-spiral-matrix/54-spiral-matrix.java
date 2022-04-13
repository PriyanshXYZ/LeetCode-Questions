class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> ans=new ArrayList();
        int m=mat.length,n=mat[0].length;
        int maxRow=m-1,maxCol=n-1;
        int minRow=0,minCol=0;
        
        int count=0;
        while(count<=m*n){
            //rightward
            for(int col=minCol;col<=maxCol;col++){
                int row=minRow;
                ans.add(mat[row][col]);
                count++;
                if(count==m*n)return ans;
            }
            minRow=minRow+1;
            
            //downward
            for(int row=minRow;row<=maxRow;row++){
                int col=maxCol;
                ans.add(mat[row][col]);
                count++;
                if(count==m*n)return ans;
            }
            maxCol=maxCol-1;
            
            //leftward
            for(int col=maxCol;col>=minCol;col--){
                int row=maxRow;
                ans.add(mat[row][col]);
                count++;
                if(count==m*n)return ans;
            }
            maxRow=maxRow-1;
            
            //upwards
            for(int row=maxRow;row>=minRow;row--){
                int col=minCol;
                ans.add(mat[row][col]);
                count++;
                if(count==m*n)return ans;
            }
            minCol=minCol+1;
        }
        return ans;
    }
}