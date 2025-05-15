class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        // effortTo[i][j] stores the minimum effort to reach cell (i, j)
        int[][] effortTo = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(effortTo[i], Integer.MAX_VALUE);
        }
        effortTo[0][0] = 0; // Effort to reach the starting cell is 0

        // Use a priority queue to select the cell with the smallest effort
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // {effort, row, col}
        pq.offer(new int[]{0, 0, 0});

        int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currEffort = curr[0];
            int r = curr[1];
            int c = curr[2];

            // If we've reached the destination, we're done
            if (r == n - 1 && c == m - 1) {
                return currEffort;
            }

            // Explore neighbors
            for (int[] dir : dirs) {
                int nextR = r + dir[0];
                int nextC = c + dir[1];

                if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < m) {
                    int nextEffort = Math.max(currEffort, Math.abs(heights[r][c] - heights[nextR][nextC])); // Calculate effort to reach neighbor

                    if (effortTo[nextR][nextC] > nextEffort) {
                        effortTo[nextR][nextC] = nextEffort;
                        pq.offer(new int[]{nextEffort, nextR, nextC}); // Add neighbor to queue
                    }
                }
            }
        }

        return 0; //Should not reach here
    }
}

class Solution1 {
    //TLE due to back
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] efforts = new int[n][m];
        for(int i=0;i<n;i++)Arrays.fill(efforts[i],Integer.MAX_VALUE);
        efforts[0][0] = 0;
        dfs(0, 0, n, m, heights, efforts);
        return efforts[n-1][m-1];
    }
    int[][] dirs = { {0, -1} , {0, 1}, {1, 0}, {-1, 0}};
    private void dfs(int r, int c, int n, int m, int[][] heights, int[][] efforts) {
        for(int[] dir : dirs) {
            int x = r + dir[0];
            int y = c + dir[1];
            if(x < 0 || y < 0 || y >= m || x >= n)continue;
            int diff = Math.abs(heights[r][c] - heights[x][y]);
            int currEffort = Math.max(efforts[r][c], diff);
            if(efforts[x][y] > currEffort){
                efforts[x][y] = currEffort;
                dfs(x , y, n, m, heights, efforts);
            }
        }
    }
}