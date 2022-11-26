class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {        
        res=new ArrayList();
        boolean[] vis=new boolean[graph.length];
        dfs(0,graph.length-1,graph,vis,new ArrayList());
        return res;
    }
    private void dfs(int src,int dest,int[][] graph,boolean[] vis,List<Integer> path){
        if(src==dest){
            path.add(src);
            // System.out.println(path);
            res.add(new ArrayList(path));
            path.remove(path.size()-1);
            return;
        }
        
        
        for(int nbr:graph[src]){
            if(!vis[nbr]){
                vis[src]=true;        
                path.add(src);
                dfs(nbr,dest,graph,vis,path);
                path.remove(path.size()-1);
                vis[src]=false;
            }
        }
        
        
    }
}