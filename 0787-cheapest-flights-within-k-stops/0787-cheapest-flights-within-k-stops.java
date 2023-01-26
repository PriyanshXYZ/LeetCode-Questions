class Solution {
    class Pair{
        int node;
        int wt;
        
        Pair(int node, int wt){
            this.node = node;
            this.wt = wt;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        dist[src]=0;
        
        for(int i=0;i<k+1;i++){
            int[] distplus1=dist.clone();
            for(int[] flight: flights){
                int u=flight[0];
                int v=flight[1];
                int wt=flight[2];
                
                if(dist[u]!=Integer.MAX_VALUE){
                    distplus1[v]=Math.min(distplus1[v],dist[u]+wt);
                }
            }
            dist=distplus1;
        }
        if(dist[dst]==Integer.MAX_VALUE){
            return -1;
        }else{
            return dist[dst];
        }
    }
    //TLE dfs
    public int dfs(int src,int dst, int k, int path,List<List<Pair>> graph,boolean[] vis){
        if(k<0)return Integer.MAX_VALUE;
        if(src==dst && k>=0)return path;
        vis[src]=true;
        int ans = Integer.MAX_VALUE;
        for(Pair nbr : graph.get(src)){
            int node = nbr.node;
            int wt = nbr.wt;
            if(vis[node]==false){
                ans = Math.min(ans, dfs(node,dst,k-1,path+wt,graph,vis));    
            }
        }
        return ans;
    }
}