class Solution {
    /** 
     k = 2
     2 -> 1
     2 -> 3 -> 4
    */
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++)graph.add(new ArrayList());
        for(int[] node : times) {
            int u = node[0];
            int v = node[1];
            int w = node[2];

            graph.get(u).add(new int[]{v,w});
        }

        // a bfs is optimal approach if i am dealing with unweighted graph
        // in case of weighted graph i should use dijkstra 
        PriorityQueue<int[]> bfsQ = new PriorityQueue<>((a,b)-> a[1] - b[1]); // sort on basis of weight ascending order
        boolean[] vis = new boolean[n+1];
        bfsQ.add(new int[]{k,0});
        int maxTime = 0;
        while(!bfsQ.isEmpty()){
            int[] node = bfsQ.remove();
            int u = node[0];
            if(vis[u])continue;
            vis[u] = true;
            n--;
            maxTime = Math.max(node[1], maxTime);
            for(int[] nbr : graph.get(u)){
                int v = nbr[0];
                int w = nbr[1];
                bfsQ.add(new int[]{v,w+node[1]});
            }
        }

        
        return n==0?maxTime:-1;
    }
}