class Solution {
    /** 
     k = 2
     2 -> 1
     2 -> 3 -> 4
    */
    public int networkDelayTime(int[][] times, int n, int k) {
       List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] time : times) {
            int sourceNode = time[0];
            int destNode = time[1];
            int edgeWeight = time[2];
            graph.get(sourceNode).add(new int[]{destNode, edgeWeight});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        minHeap.offer(new int[]{k, 0});

        int nodesVisited = 0; // Keep track of visited nodes
        int maxTime = 0;

        while (!minHeap.isEmpty()) {
            int[] node = minHeap.poll();
            int u = node[0];
            int timeFromSource = node[1];

            if (timeFromSource > dist[u]) {
                continue; // Important optimization: Skip if we've found a shorter path
            }

            nodesVisited++;
            maxTime = Math.max(timeFromSource, maxTime);

            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];
                if (dist[v] > dist[u] + weight) {
                    dist[v] = dist[u] + weight;
                    minHeap.offer(new int[]{v, dist[v]});
                }
            }
        }

        if (nodesVisited != n) {
            return -1;
        }
        return maxTime;
    }
}