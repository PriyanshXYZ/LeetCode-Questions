class Solution {
    Integer[] dp;
    public int minimumTime(int n, int[][] relations, int[] time) {
        int indegree[] = new int[n];
        Map<Integer,List<Integer>> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int[] edge : relations){
            int u = edge[0]-1;
            int v = edge[1]-1;

            map.get(u).add(v);
            indegree[v]++;
            
        }
        dp = new Integer[n];
        
//         int[] maxTime = new int[n];
//         Queue<Integer> q = new ArrayDeque<>();
//         for(int i=0;i<n;i++){
//             if(indegree[i]==0){
//                 q.add(i);
//                 maxTime[i]=time[i];
//             }
//         }
        
//         while(q.size()>0){
//             int rem = q.remove();

//             for(int nbr : map.get(rem)){
//                 if(time[nbr] + maxTime[rem] > maxTime[nbr]){
//                     maxTime[nbr] = time[nbr] + maxTime[rem];
//                 }
//                 indegree[nbr]--;
//                 if(indegree[nbr]==0)q.add(nbr);
//             }

//         }
        int ans = 0;
        for(int i=0;i<n;i++){
            ans = Math.max(dfs(i,time,map),ans);
        }
        return ans;
    }
    int dfs(int node, int[] time, Map<Integer,List<Integer>> graph){
        if(dp[node]!=null)return dp[node];
        
        if(graph.get(node).size()==0){
            return time[node];
        }
        int ans = 0;
        for(int nbr : graph.get(node)){
            ans = Math.max(ans, dfs(nbr,time,graph));
        }
        return dp[node] = ans + time[node];
    }
}