class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] vis = new int[graph.length];
        
        for(int i=0;i<graph.length;i++){
            if(vis[i]==0){
                if(hasOddCycle(i,graph,1,vis)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean hasOddCycle(int node, int[][] graph, int color, int[] vis){
        if(vis[node]!=0){
            if(vis[node]==color)//even length cycle
                return false;
            else return true;
        }
        
        vis[node]=color;
        for(int nbr : graph[node]){
            if(hasOddCycle(nbr,graph,color*-1,vis)){
                return true;
            }
        }
        return false;
    }
}
class Solution1 {
    //using bfs and checking the  lvl of vtces at which we are visiting again if sum is odd then it is odd cycle..and return false;
    class Pair{
        int src;
        int lvl;
        
        Pair(int src,int lvl){
            this.src=src;
            this.lvl=lvl;
        }
    }
    
    public boolean hasOddCycle(int[][] graph,int src,int[] visited){
        Queue<Pair> q=new ArrayDeque();
        
        q.add(new Pair(src,1));
        while(q.size()!=0){
            Pair rPair=q.remove();
            //if the element was already present then visited[idx]will not be -1
            if(visited[rPair.src]!=-1){
                if((rPair.lvl + visited[rPair.src])%2==1){
                    return true;   
                }else{
                    continue;
                }
            }
            //updating once visited
            visited[rPair.src]=rPair.lvl;
            
            for(int nbr:graph[rPair.src]){
                q.add(new Pair(nbr,rPair.lvl+1));
            }
        }
        
        return false;
    }
    public boolean isBipartite(int[][] graph) {
        int[] visited=new int[graph.length];
        Arrays.fill(visited,-1);
        for(int u=0;u<graph.length;u++){
            if(visited[u]==-1){
                boolean isOddCycle=hasOddCycle(graph,u,visited);
                if(isOddCycle)return false;
            }
        }
        return true;
    }
}
class Solution2 {
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
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        
        UF uf = new UF(n);
        for(int i=0;i<n;i++){
            for(int nbr : graph[i]){
                if(uf.find(i)==uf.find(nbr))return false;
                uf.union(i,nbr);
            }
        }
        return true;
    }
    
}