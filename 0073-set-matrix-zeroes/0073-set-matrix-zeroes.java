class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        boolean isZeroCol = false;
       
        
        for(int i=0;i<n;i++){
            if(matrix[i][0] == 0){
                isZeroCol = true;
            }
            for(int j=1;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
            
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[j][0] == 0 || matrix[0][i]==0){
                    matrix[j][i]=0;
                }
            }
        }
        
        if(matrix[0][0] == 0){
            for(int i=0;i<m;i++){
                matrix[0][i] = 0;
            }
        }
        
        if(isZeroCol){
            for(int i=0;i<n;i++){
                matrix[i][0]=0;
            }
        }
    }
}