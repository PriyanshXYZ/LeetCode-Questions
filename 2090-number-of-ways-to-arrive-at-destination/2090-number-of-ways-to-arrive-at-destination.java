class Solution {
    int mod = (int)(1e9+7);
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();

        for(int i=0;i<n;i++)graph.add(new ArrayList());

        for(int[] road : roads) {
            int src = road[0];
            int nbr = road[1];
            int wt = road[2];

            graph.get(src).add(new int[]{nbr, wt});
            graph.get(nbr).add(new int[]{src,wt});
        }

        int[] ways = new int[n];
        long[] times = new long[n];

        Arrays.fill(times,Long.MAX_VALUE);
        PriorityQueue<long[]> minHeap = new PriorityQueue<>((a,b)->((int)a[1]-(int)b[1]));
        minHeap.add(new long[]{0,0});
        ways[0] = 1;
        times[0] = 0;

        while(!minHeap.isEmpty()) {
            long[] remElement = minHeap.remove();
            long time = remElement[1];
            int node = (int)remElement[0];

            if(times[node] < time)continue;

            for(int[] nbr : graph.get(node)) {
                int nbrNode = nbr[0];
                int nbrTime = nbr[1];

                if(time+nbrTime < times[nbrNode]){
                    times[nbrNode] = time+nbrTime;
                    ways[nbrNode] = ways[node];
                    minHeap.add(new long[]{nbrNode,times[nbrNode]});
                }else if(time+nbrTime == times[nbrNode]){
                    ways[nbrNode] =(ways[nbrNode] + ways[node])%mod;
                }
            }
        }
        return ways[n-1];
    }
}