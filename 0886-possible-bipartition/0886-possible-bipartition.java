class Solution {
    //using graph coloring i.e dfs
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList();
        for(int i=0;i<=n;i++)graph.add(new ArrayList());
        
        for(int[] edge : dislikes){
            int u = edge[0];
            int v = edge[1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int[] color = new int[n+1];
        for(int vtc = 1; vtc <=n; vtc++){
            if(color[vtc] == 0){
                if(!sameColor(vtc, graph,1, color))return false;
            }
        }
        return true;
    }
    public boolean sameColor(int src, List<List<Integer>> graph,int color, int[] assignedColor){
        if(assignedColor[src] != 0){
            return assignedColor[src] == color;
        }
        
        assignedColor[src] = color;
        for(int nbr : graph.get(src)){
            if(sameColor(nbr, graph,-color,assignedColor) == false)return false;
        }
        return true;
    }
}
class Solution1 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        //bipartite is only possible when 
        //1. when there is no cycle present
        //2. if cycle is present it must be even in color.
        
        List<List<Integer>> graph = new ArrayList();
        for(int i=0;i<=n;i++)graph.add(new ArrayList());
        
        for(int[] edge : dislikes){
            int u = edge[0];
            int v = edge[1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        int[] vis = new int[n + 1];
        Arrays.fill(vis, -1);
        for(int vtc = 1; vtc <=n; vtc++){
            if(vis[vtc] == -1){
                if(hasOddCycle(vtc, graph, vis))return false;
            }
        }
        return true;
    }
    class Pair{
        int node;
        int len;
        Pair(int node, int len){
            this.node = node;
            this.len = len;
        }
    }
    public boolean hasOddCycle(int src, List<List<Integer>> graph, int[] vis){
        Queue<Pair> q = new ArrayDeque();
        q.add(new Pair(src, 0));
        
        while(q.size()>0){
            Pair rem = q.remove();
            if(vis[rem.node]!=-1){
                //cycle is present and now we need need to check the length of the cycle
                if((vis[rem.node] + rem.len) % 2 == 1)return true;
            }
            vis[rem.node] = rem.len;
            for(int nbr : graph.get(rem.node)){
                if(vis[nbr]==-1)
                    q.add(new Pair(nbr,rem.len + 1));
            }
        }
        return false;
    }
}