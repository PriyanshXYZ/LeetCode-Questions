class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination)return true;
        List<List<Integer>> graph = new ArrayList();
        
        for(int i=0;i<n;i++)graph.add(new ArrayList());
        
        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        return dfs(source , destination, graph, new boolean[n]);
    }
    public boolean dfs(int src, int dest, List<List<Integer>> graph, boolean[] vis){
        if(src == dest)return true;
        vis[src] = true;
        for(int nbr : graph.get(src)){
            if(vis[nbr])continue;
            if(dfs(nbr, dest, graph, vis))return true;
        }
        return false;
    }
}