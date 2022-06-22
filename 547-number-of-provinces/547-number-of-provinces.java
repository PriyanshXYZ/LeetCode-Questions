class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        ArrayList<Integer>[] graph=new ArrayList[n];
        
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList();
        }
        for(int u=0;u<n;u++){
            for(int v=0;v<n;v++){
                if(isConnected[u][v]==1){
                    graph[u].add(v);
                    graph[v].add(u);
                }
            }
        }
        int count=0;
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                dfs(graph,i,vis);
                count++;
            }
        }
        return count;
    }
    public void dfs(ArrayList<Integer>[] graph,int src,boolean[] vis){
        vis[src]=true;
        
        for(int nbr: graph[src]){
            if(vis[nbr]==false){
                dfs(graph,nbr,vis);
            }
        }
    }
}