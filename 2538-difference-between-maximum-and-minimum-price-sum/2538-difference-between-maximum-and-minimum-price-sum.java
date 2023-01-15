class Solution {
    public long maxOutput(int n, int[][] edges, int[] price) {
        List<List<Integer>> graph = new ArrayList();
        dp =new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList());
            dp.add(new HashMap());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        
        long res = 0;
        for(int i=0;i<n;i++){
            long maxSum = dfs(i,-1,graph,price) - (long)price[i];
            res = Math.max(res, maxSum);
        }
        return res;
    }
    List<Map<Integer,Long>> dp;
    public long dfs(int src,int prev, List<List<Integer>> graph, int[] price){
        if(graph.get(src).size()==0)return 0;
        
        if(dp.get(src).containsKey(prev)) return dp.get(src).get(prev);
        
        long sum=0;
        for(int nbr : graph.get(src)){
            if(nbr==prev)continue;
            long childSum = dfs(nbr,src,graph,price);
            
            sum = Math.max(childSum, sum);
        }
        sum += price[src];
        dp.get(src).put(prev,sum);
        return sum;
    }
}