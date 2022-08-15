class Solution {
    List<List<Integer>> res;
    int[] discovery;
    int[] lowest;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph=new ArrayList();
        
        for(int i=0;i<n;i++)graph.add(new ArrayList());
        
        for(List<Integer> list:connections){
            int u=list.get(0);
            int v=list.get(1);
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        //articulation point
        res=new ArrayList();
        
        discovery=new int[n];
        lowest=new int[n];
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i])
                dfs(i,-1,graph,vis,0);
        }
        return res;
    }
    
    public void dfs(int src,int par,List<List<Integer>> graph,boolean[] vis,int level){
        discovery[src]=level;
        lowest[src]=level;
        
        vis[src]=true;
        
        for(int nbr:graph.get(src)){
            if(nbr==par){
                continue;
            }
            if(vis[nbr]==true){
                lowest[src]=Math.min(discovery[nbr],lowest[src]);
            }else{
                dfs(nbr,src,graph,vis,level+1);
                lowest[src]=Math.min(lowest[nbr],lowest[src]);
                
                if(discovery[src]<lowest[nbr]){
                    List<Integer> list=new ArrayList();
                    list.add(src);
                    list.add(nbr);
                    res.add(list);
                }
            }
        }
    }
}