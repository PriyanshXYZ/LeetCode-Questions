class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visit = new boolean[n];
        int[] indegree = new int[n];

        // Count indegree of each node.
        for (int edge : edges) {
            if (edge != -1) {
                indegree[edge]++;
            }
        }

        // Kahn's algorithm starts.
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            visit[node] = true;
            int neighbor = edges[node];
            if (neighbor != -1) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }
        // Kahn's algorithm ends.

        int answer = -1;
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                int neighbor = edges[i];
                int count = 1;
                visit[i] = true;
                // Iterate in the cycle.
                while (neighbor != i) {
                    visit[neighbor] = true;
                    count++;
                    neighbor = edges[neighbor];
                }
                answer = Math.max(answer, count);
            }
        }
        return answer;
    }
}
class Solution1 {
    int cycleSize=-1;
    public void dfs(int src, int[] graph, int[] vis,boolean[] pathVis,int sum){
        sum += 1;
        vis[src] = sum;
        pathVis[src]=true;
        if(graph[src]!=-1){
            int nbr =graph[src];
            if(vis[nbr] == -1){
                dfs(nbr, graph, vis, pathVis, sum);
            }else if(pathVis[nbr]==true){
                cycleSize = Math.max(cycleSize, 1 + sum - vis[nbr]);
            }    
        }
        pathVis[src] = false;
    }
    public int longestCycle(int[] edges) {
        int N = edges.length;
        int[] vis = new int[N];
        Arrays.fill(vis,-1);
        for(int i=0;i<N;i++){
            if(vis[i]==-1)
                dfs(i, edges, vis, new boolean[N], 0);    
        }
        
        return cycleSize;
    }
}