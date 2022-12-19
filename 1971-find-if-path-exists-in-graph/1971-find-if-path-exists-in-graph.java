class Solution {
    class UF{
        int[] parent;
        int[] rank;
        UF(int n){
            this.parent = new int[n];
            this.rank = new int[n];
            for(int i = 0; i < n; i++){
                parent[i]=i;
            }
        }
        int find(int x){
            if(parent[x] != x){
                return find(parent[x]);
            }
            return x;
        }
        void union(int x, int y){
            int xLead = find(x);
            int yLead = find(y);
            
            if(xLead != yLead){
                if(rank[xLead] > rank[yLead])
                    parent[yLead]=xLead;
                else if(rank[yLead]>rank[xLead])
                    parent[xLead]=yLead;
                else{
                    parent[xLead]=yLead;
                    rank[yLead]++;
                }   
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UF uf = new UF(n);
        
        for(int[] edge : edges){
            uf.union(edge[0], edge[1]);
        }
        return uf.find(source) == uf.find(destination);
    }
}
class Solution1 {
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