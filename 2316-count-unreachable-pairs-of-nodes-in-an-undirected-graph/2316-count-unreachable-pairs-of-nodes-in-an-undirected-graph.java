class Solution {
    class DSU{
        int[] parent;
        int[] rank;
        
        public DSU(int n){
            parent = new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
            rank = new int[n];
        }
        
        public int find(int x){
            if(x == parent[x]){
                return x;
            }else{
                return find(parent[x]);
            }
        }
        
        void union(int x, int y){
            int xLead = find(x);
            int yLead = find(y);
            
            if(xLead != yLead){
                if(rank[xLead] > rank[yLead])
                    parent[yLead]=xLead;
                else if(rank[yLead]>rank[xLead])
                    parent[xLead]=yLead;
                else{
                    parent[xLead]=yLead;
                    rank[yLead]++;
                }
            }
        }
    }
    public long countPairs(int n, int[][] edges) {
        DSU uf = new DSU(n);
        
        for(int[] e : edges){
            uf.union(e[0],e[1]);
        }
        
        Map<Integer,Integer> componentSize = new HashMap<>();
        for(int i=0;i<n;i++){
            int parent = uf.find(i);
            if(!componentSize.containsKey(parent)){
                componentSize.put(parent,0);
            }
            componentSize.put(parent, componentSize.get(parent)+1);
        }
        // System.out.println(componentSize);
        
        long unreachable = 0;
        long remaining = n;
        
        for(int val : componentSize.values()){
            unreachable += val * (remaining - val);
            remaining -= val;
        }
        return unreachable;
    }
}