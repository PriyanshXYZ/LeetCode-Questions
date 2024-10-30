class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int save = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = save;
            }
        }
        
        //reverse the matrix
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int save = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = save;
            }
        }
    }
}