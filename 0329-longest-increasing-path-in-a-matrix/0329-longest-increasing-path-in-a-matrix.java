public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] indegree = new int[m][n];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        // Compute indegree for each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] dir : dirs) {
                    int ni = i + dir[0], nj = j + dir[1];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && matrix[ni][nj] < matrix[i][j]) {
                        indegree[i][j]++;
                    }
                }
            }
        }

        // Initialize the queue with all cells that have indegree 0
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (indegree[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int maxIncPath = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] cell = queue.poll();
                int i = cell[0], j = cell[1];
                for (int[] dir : dirs) {
                    int ni = i + dir[0], nj = j + dir[1];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && matrix[ni][nj] > matrix[i][j]) {
                        indegree[ni][nj]--;
                        if (indegree[ni][nj] == 0) {
                            queue.offer(new int[]{ni, nj});
                        }
                    }
                }
            }
            maxIncPath++;
        }
        
        return maxIncPath;
    }
}

class Solution1 {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = 1;
            }  
        }
        
        int maxLen = 0;
        // Create a list of cells with their values, and sort by value.
        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cells.add(new Cell(i, j, matrix[i][j]));
            }
        }
        Collections.sort(cells, (a, b) -> a.val - b.val); // Sort by cell value

        int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        // Process cells in sorted order.
        for (Cell cell : cells) {
            int r = cell.row;
            int c = cell.col;
            dp[r][c] = 1; // Initialize the longest increasing path ending at (r, c)

            for (int[] dir : dirs) {
                int prevR = r + dir[0];
                int prevC = c + dir[1];
                if (isValidIdx(prevR, prevC, n, m) && matrix[prevR][prevC] < matrix[r][c]) {
                    dp[r][c] = Math.max(dp[r][c], 1 + dp[prevR][prevC]);
                }
            }
            maxLen = Math.max(maxLen, dp[r][c]);
        }

        return maxLen;
    }

    private boolean isValidIdx(int r, int c, int n, int m) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }

    // Helper class to store cell information.
    private static class Cell {

        int row;
        int col;
        int val;

        Cell(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
}