class Solution {
    /**
        ["1","0","1","0","0"]
        ["1","0","1","1","1"]
        ["1","1","1","1","1"]
        ["1","0","0","1","0"]

        i am part of bigger square if left right and diagonal is also part of a square
        else i  would be just 1
     */

    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n+1][m+1];
        int maxLen = 0;
        for(int i=0;i<n;i++){
            if(matrix[i][0] == '1'){
                dp[i][0] = 1;
                maxLen = 1;
            }
        }

        for(int j=0;j<m;j++){
            if(matrix[0][j] == '1'){
                dp[0][j] = 1;
                maxLen = 1;
            }
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m ; j++){
                int ans = 0;
                if(matrix[i][j] == '1'){
                    ans = 1;
                    int ansLeft = dp[i][j - 1];
                    int ansTop = dp[i - 1][j];
                    int ansDiagonal = dp[i - 1][j - 1];

                    int minEdgeLength = Math.min(ansLeft, ansTop);
                    minEdgeLength = Math.min(minEdgeLength, ansDiagonal);

                    ans += minEdgeLength;
                }

                dp[i][j] = ans;
                maxLen = Math.max(ans, maxLen);
            }
        }

        return maxLen * maxLen;
    }

    public int memoize(int currRow, int currCol, int n , int m, char[][] matrix, Integer[][] dp) {
        //base case
        if(currRow == n || currCol == m || matrix[currRow][currCol] == '0')return dp[currRow][currCol] = 0;
        //cache
        if(dp[currRow][currCol] != null) return dp[currRow][currCol];
        //main logic
        int ansRight = memoize(currRow, currCol + 1, n, m, matrix, dp);
        int ansBottom = memoize(currRow + 1, currCol, n, m, matrix, dp);
        int ansDiagonal = memoize(currRow + 1, currCol + 1, n, m, matrix, dp);

        int ans = Math.min(1 + ansRight, 1 + ansBottom);
        ans = Math.min(1 + ansDiagonal, ans);
        
        return dp[currRow][currCol] = ans;
    }
}