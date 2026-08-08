class Solution {
public:
    int numberOfUniquePath(int i, int j, int n, int m, vector<vector<int>>& grid, vector<vector<int>> &dp){
        if(i <0 || j<0 || i>=n || j>=m || grid[i][j]==1)
            return 0;
            
        if(dp[i][j] != -1) return dp[i][j];
        if(i == n-1 && j == m-1){
            return 1;
        }
        
        int down = numberOfUniquePath(i+1, j, n , m, grid, dp);
        int right = numberOfUniquePath(i, j+1, n, m, grid, dp);
        
        dp[i][j] = down + right;
        return dp[i][j];
        
    }
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int n= obstacleGrid.size();
        int m= obstacleGrid[0].size();
        vector<vector<int>> dp(n+1, vector<int>(m+1, -1));
        return numberOfUniquePath(0, 0, n, m, obstacleGrid, dp);
    }
};
