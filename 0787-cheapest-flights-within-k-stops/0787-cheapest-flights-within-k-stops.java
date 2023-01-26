class Solution {
    class Pair{
        int node;
        int wt;
        
        Pair(int node, int wt){
            this.node = node;
            this.wt = wt;
        }
    }
    int res=Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        return bellmanFord(n,flights,src,dst,k);
//         List<List<Pair>> graph = new ArrayList();
        
//         for(int i = 0;i<n;i++)graph.add(new ArrayList());
        
//         for(int[] flight : flights){
//             int u = flight[0];
//             int v = flight[1];
//             int cost = flight[2];
            
//             graph.get(u).add(new Pair(v,cost));
//         }
//         boolean[] vis = new boolean[n];
//         memo(src,dst,k+1,0,graph,vis);
        
//         if(res == Integer.MAX_VALUE)return -1;
//         return res;
    }
    public int bellmanFord(int n, int[][] flights, int src, int dst, int k){
       int[][] dp = new int[n][k+2];
        for(int i =0;i<n;i++){
            if(i!=src)
                Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        
        for(int i=1;i<=k+1;i++){
            for(int[] f : flights){
                int u = f[0];
                int v = f[1];
                int wt = f[2];
                
                if(dp[u][i-1]!=Integer.MAX_VALUE){
                    dp[v][i]=Math.min(dp[v][i],dp[u][i-1]+wt);
                }
            }
        }
        return dp[dst][k+1]==Integer.MAX_VALUE?-1:dp[dst][k+1];
    }
    //TLE dfs
    public int dfs(int src,int dst, int k, int path,List<List<Pair>> graph){
        if(k<0)return Integer.MAX_VALUE;
        if(src==dst && k>=0)return path;
        
        int ans = Integer.MAX_VALUE;
        for(Pair nbr : graph.get(src)){
            int node = nbr.node;
            int wt = nbr.wt;
            
            ans = Math.min(ans, dfs(node,dst,k-1,path+wt,graph));    
            
        }
        return ans;
    }
    public void memo(int src,int dst, int k, int path,List<List<Pair>> graph,boolean[] vis){
        if(k<0)return;
        if(src==dst && k>=0){
            res = Math.min(res,path);
            return;
        }
        
        vis[src]=true;
        
        for(Pair nbr : graph.get(src)){
            int node = nbr.node;
            int wt = nbr.wt;
            if(wt+path>res)continue;
            if(vis[node]==false)
                memo(node,dst,k-1,path+wt,graph,vis);
            
        }
        vis[src]=false;
    }
}