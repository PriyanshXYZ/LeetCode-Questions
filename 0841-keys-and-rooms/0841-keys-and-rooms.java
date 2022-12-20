class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis = new boolean[rooms.size()];
        dfs(0, rooms, vis);
        for(boolean gye : vis){
            if(!gye)return false;
        }
        return true;
    }
    private void dfs(int src, List<List<Integer>> graph, boolean[] vis){
        vis[src] = true;
        for(int nbr : graph.get(src)){
            if(vis[nbr])continue;
            dfs(nbr, graph, vis);
        }
    }
}