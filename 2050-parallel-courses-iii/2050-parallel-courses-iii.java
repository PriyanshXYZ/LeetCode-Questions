class Solution {
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
        
        int[] maxTime = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
                maxTime[i]=time[i];
            }
        }
        
        while(q.size()>0){
            int rem = q.remove();

            for(int nbr : map.get(rem)){
                if(time[nbr] + maxTime[rem] > maxTime[nbr]){
                    maxTime[nbr] = time[nbr] + maxTime[rem];
                }
                indegree[nbr]--;
                if(indegree[nbr]==0)q.add(nbr);
            }

        }
        int ans = 0;
        for(int i=0;i<n;i++){
            ans = Math.max(maxTime[i],ans);
        }
        return ans;
    }
}