class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> graph = new ArrayList();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        res = new int[n];
        boolean[] vis = new boolean[n];
        dfs(0, graph, labels, vis);
        return res;
    }
    int[] res;
    public int[] dfs(int src, List<List<Integer>> graph, String labels, boolean[] vis){
        vis[src]= true;
        if(graph.get(src).size()==0){//end node
            int[] freq = new int[26];
            freq[labels.charAt(src)-'a']++;
            res[src] = 1;
            return freq;
        }
        int[] freq = new int[26];
        for(int nbr : graph.get(src)){
            if(!vis[nbr]){
                int[] fc= dfs(nbr, graph, labels,vis);
                for(int i = 0;i<26;i++){
                    freq[i] += fc[i];
                }    
            }
            
        }
        freq[labels.charAt(src)-'a']++;
        res[src] = freq[labels.charAt(src)-'a'];
        return freq;
    }
}