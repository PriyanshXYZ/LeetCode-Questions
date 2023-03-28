class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0;i<n;i++)graph.add(new ArrayList<>());
        
        for(int[] c : connections){
            graph.get(c[0]).add(c[1]);
            graph.get(c[1]).add(-c[0]);
        }
        return dfs(0,graph, new boolean[n]);
    }
    
    int dfs(int src, List<List<Integer>> graph,boolean[] vis){
        int rev = 0;
        vis[src] = true;
        for(int nbr : graph.get(src)){
            if(vis[Math.abs(nbr)]!=true){
                rev += dfs(Math.abs(nbr), graph, vis);
                rev += nbr > 0?1:0;
            }
        }
        return rev;
    }
}