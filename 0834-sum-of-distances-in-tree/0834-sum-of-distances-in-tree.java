class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        //dfs 1 -> find the sum for root and get the array of size of subtree for every node
        //dfs 2 -> just ans[parent] - subtreeSize[child] + n - subtreeSize[child]
        List<List<Integer>> graph = new ArrayList();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u); // remember to make tree bidirectional
        }
        
        int[] subtreeSize = new int[n];
        int currSum = dfs1(0,-1, 0, graph, subtreeSize);

        int[] dist = new int[n];
        dfs2(0, -1, currSum, graph, dist, subtreeSize);

        return dist;
    }

    private int dfs1(int node,int par, int currDist, List<List<Integer>> graph, int[] subtreeSize) {
        subtreeSize[node] += 1;
        int ans = currDist ;
        for(int child : graph.get(node)){
            if(child==par)continue;
            ans += dfs1(child, node, currDist + 1, graph, subtreeSize);
            subtreeSize[node] += subtreeSize[child];
        }
        return ans;
    }

    private void dfs2(int node,int par, int currSum, List<List<Integer>> graph, int[] dist, int[] subtreeSize) {
        dist[node] = currSum;

        for(int child : graph.get(node)) {
            if(child==par)continue;
          int sum = currSum + dist.length - subtreeSize[child] - subtreeSize[child];
          dfs2(child, node, sum, graph, dist, subtreeSize);
        }
    }
}