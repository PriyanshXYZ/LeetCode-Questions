class Solution {
    //using dfs
    public boolean isBipartite(int[][] graph) {
        int vtces=graph.length;
        int[] vis=new int[vtces];
        int color=1;//1=> red color -1=> green color
        for(int v=0;v<vtces;v++){
            if(vis[v]==0){
                boolean bipartite=dfs(graph,v,vis,color);
                if(bipartite==false)return false;
            }
        }
        return true;
    }
    
    public boolean dfs(int[][] graph,int src,int[] vis,int color){
        //base case 
        if(vis[src]!=0){//meaning there is a cycle 
            int oc=vis[src];
            if(oc==color){//even cycle
                return true;
            }else{//odd cycle
                return false;
            }
        }
        
        vis[src]=color;
        for(int nbr:graph[src]){
            
            boolean ans=dfs(graph,nbr,vis,color*-1);
            if(ans==false)return false;

        }
        return true;
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