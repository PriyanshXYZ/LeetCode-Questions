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
        int lo = 0;
        int hi = (int)(1e6);
        while(lo < hi) {
            int mid = lo + (hi - lo) /2;
            if(dfs(0, 0, mid, heights, new boolean[n][m])){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        
        return lo;
    }

    int[][] dirs = { {0, -1} , {0, 1}, {1, 0}, {-1, 0}};

    private boolean dfs(int r, int c, int limit, int[][] heights, boolean[][] vis) {
        if(r == heights.length - 1 && c == heights[0].length - 1)return true;
        vis[r][c] = true;
        boolean ans = false;
        for(int[] dir : dirs) {
            int x = r + dir[0];
            int y = c + dir[1];
            
            if(x < 0 || y < 0 || y >= heights[0].length || x >= heights.length || vis[x][y])continue;
            
            int diff = Math.abs(heights[r][c] - heights[x][y]);
            if(diff<=limit)
                ans |= dfs(x , y, limit, heights, vis);
        }
        return ans;
    }
}