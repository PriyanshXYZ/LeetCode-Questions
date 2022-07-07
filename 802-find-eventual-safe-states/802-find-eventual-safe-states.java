class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //grapg has n vertices
        int vtces=graph.length;
        ArrayList<Integer> res=new ArrayList();
        vis=new int[vtces];
        for(int i=0;i<vtces;i++){
            if(vis[i]==0){
                boolean safe=cycleDetect(graph,i);
                if(safe)res.add(i);
            }else if(vis[i]==2){
                res.add(i);
            }
        }
        return res;
    }
    int[] vis;
    public boolean cycleDetect(int[][] graph,int src){
        if(vis[src]==1){//we are visiting already visited vertex
            return false;
        }else if(vis[src]==2){
            return true;
        }else{
            vis[src]=1;
            
            for(int nbr:graph[src]){
                boolean isNbrSafe=cycleDetect(graph,nbr);
                if(isNbrSafe==false){
                    return false;
                }
            }
        }
        
        vis[src]=2;
        return true;
    }
    
}