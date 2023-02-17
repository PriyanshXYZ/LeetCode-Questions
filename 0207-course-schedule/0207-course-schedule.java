class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }
        
        int[] vis=new int[numCourses];
        int[] dfsVis=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(vis[i]==0){
                boolean cycle=detectCycle(adj,i,vis,dfsVis);
                if(cycle)return false;
            }
        }
        return true;
    }
    private boolean detectCycle(List<List<Integer>> adj,int src,int[] vis,int[] dfsVis){
        if(vis[src]==1){
            if(dfsVis[src]==1)
                return true;
            else return false;
        }else{
            vis[src]=1;
            for(int nbr :adj.get(src)){
                dfsVis[src]=1;
                boolean flag=detectCycle(adj,nbr,vis,dfsVis);
                if(flag)return true;
                dfsVis[src]=0;
            }
        }
        return false;
    }
}