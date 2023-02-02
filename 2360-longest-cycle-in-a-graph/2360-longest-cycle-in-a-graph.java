class Solution {
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