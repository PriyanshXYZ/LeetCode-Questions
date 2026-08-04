class Solution {
    public int maximumDetonation(int[][] bombs) {
        // 1. iterate through each bomb -> bfs on it -> keep the count -> return the maximum count
        int n = bombs.length;
        int maxDetonation = 0;

        for(int i = 0; i < n; i++) {
            maxDetonation = Math.max(bfs(i, bombs), maxDetonation);
        }
        return maxDetonation;
    }

    private int bfs(int bombIdx, int[][] bombs) {
        boolean[] vis = new boolean[bombs.length];
        Queue<Integer> q = new ArrayDeque(); // add index to queue
        q.add(bombIdx);
        vis[bombIdx] = true;
        int currDetonations = 1; 
        while(!q.isEmpty()) {
            int idxOfBomb = q.remove();
            currDetonations += findBombsInRange(q, idxOfBomb, bombs, vis); //adds to the queue the bombs that lies in the range
        }
        return currDetonations;
    }

    private int findBombsInRange(Queue<Integer> q, int idx, int[][] bombs, boolean[] vis) {
        //use distance formula squared d^2 <= r^2
        int n = bombs.length;
        int count = 0;
        for(int i=0; i<n; i++){
            if(idx == i || vis[i])continue;
            long x2x1 = bombs[idx][0] - bombs[i][0];
            long xAxisSq = x2x1 * x2x1;
            long y2y1 = bombs[idx][1] - bombs[i][1];
            long yAxisSq = y2y1 * y2y1;
            long radSq = (long)bombs[idx][2] * (long)bombs[idx][2];

            if(radSq >= (xAxisSq + yAxisSq)) {
                q.add(i);
                count++;
                vis[i] = true;
            }
        }
        return count;
    }
}