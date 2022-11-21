class Solution {
    
    private long dfs(int node,int par,List<List<Integer>> graph,int seats){
        long count=1;
        for(int nbr:graph.get(node)){
            if(nbr==par)continue;
            count+=dfs(nbr,node,graph,seats);
        }
        
        if(node>0){
            ans+=(count+seats-1)/seats;
        }
        return count;
    }
    long ans;
    public long minimumFuelCost(int[][] roads, int seats) {
        List<List<Integer>> graph=new ArrayList();
        if(roads.length==0)return 0;
        
        for(int i=0;i<=roads.length;i++)graph.add(new ArrayList());
        
        for(int[] road:roads){
            int u=road[0];
            int v=road[1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        // boolean[] vis=new boolean[roads.length+1];
        ans=0;
        dfs(0,-1,graph,seats);
        return ans;
    }
    
}