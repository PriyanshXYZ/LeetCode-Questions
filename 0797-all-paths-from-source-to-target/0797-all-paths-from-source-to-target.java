class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {        
        res=new ArrayList();
        List<Integer> path=new ArrayList();
        path.add(0);
        dfs(0,graph.length-1,graph,path);
        return res;
    }
    private void dfs(int src,int dest,int[][] graph,List<Integer> path){
        if(src==dest){
            res.add(new ArrayList(path));
            return;
        }
        for(int nbr:graph[src]){
                path.add(nbr);
                dfs(nbr,dest,graph,path);
                path.remove(path.size()-1);
        }
    }
}