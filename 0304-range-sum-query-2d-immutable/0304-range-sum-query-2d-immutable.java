class NumMatrix {
    int[][] dp;

    public NumMatrix(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0)return;
        dp=new int[matrix.length+1][matrix[0].length+1];
        for(int r=1;r<=matrix.length;r++){
            for(int c=1;c<=matrix[0].length;c++){
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1] - dp[r - 1][c - 1] + matrix[r - 1][c - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int totalSumR2C2 = dp[row2+1][col2+1];
        int totalSumR2C1 = dp[row2+1][col1];
        int totalSumR1C2 = dp[row1][col2+1];
        int totalSumR1C1 = dp[row1][col1];

        return totalSumR2C2 - totalSumR2C1 - totalSumR1C2 + totalSumR1C1;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */