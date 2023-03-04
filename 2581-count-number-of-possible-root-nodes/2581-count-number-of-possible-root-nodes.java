class Solution {
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = edges.length+1;
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        // System.out.println(n);
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        HashSet<String> guess = new HashSet<>();
        for(int[] g : guesses){
            int u = g[0];
            int v = g[1];
            guess.add(u+","+v);
        
        }
        dp = new HashMap<>();
        int ans = 0;
        for(int i=0;i<n;i++){
            int count = dfs(i,-1,graph,guess);
            if(count>=k)ans+=1;
        }
        return ans;
    }
    Map<String, Integer> dp;
    public int dfs(int src, int par, List<List<Integer>> graph,HashSet<String> guess){
        
        if(dp.containsKey(par+","+src))return dp.get(par+","+src);
        int ans =0;
        for(int child : graph.get(src)){
            if(child==par)continue;
            ans += dfs(child,src, graph, guess);
        }
        if(guess.contains(par+","+src)){
            ans+=1;
        }
        dp.put(par+","+src,ans);
        return ans;
    }
}