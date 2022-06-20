class Solution {
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