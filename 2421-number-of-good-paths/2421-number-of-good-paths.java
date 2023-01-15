class Solution {
    class UF{
        int[] parents;
        int[] ranks;
        public UF(int n){
            parents = new int[n];
            ranks = new int[n];
            for(int i = 0;i<n;i++)parents[i]=i;
        }
        
        public int find(int x){
            if(parents[x]!=x){
                return parents[x]=find(parents[x]);
            }
            return x;
        }
        
        public void union(int x, int y){
            int xlead = find(x);
            int ylead = find(y);
            
            if(xlead!=ylead){
                if(ranks[xlead]>ranks[ylead]){
                    parents[ylead] = xlead;
                }else if(ranks[ylead]>ranks[xlead]){
                    parents[xlead] = ylead;
                }else{
                    parents[xlead] = ylead;
                    ranks[ylead]++;
                }
            }
        }
    }
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        Map<Integer,Set<Integer>> graph = new HashMap<>();
        Map<Integer,Set<Integer>> sortedNodes = new TreeMap<>();
        
        int n =vals.length;
        
        for(int i=0;i<n;i++){
            if(!sortedNodes.containsKey(vals[i])){
                sortedNodes.put(vals[i],new TreeSet());
            }
            sortedNodes.get(vals[i]).add(i);
            graph.put(i,new HashSet());
        }   
        
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        UF uf = new UF(n);
        int goodPaths = 0;
        
        for(int key : sortedNodes.keySet()){
            for(int node : sortedNodes.get(key)){
                if(!graph.containsKey(node))continue;
                for(int nbr : graph.get(node)){
                    if(vals[node]>=vals[nbr]){
                        uf.union(node,nbr);
                    }
                }
            }
            
            Map<Integer,Integer> unionSize = new HashMap<>();
            
            for(int u : sortedNodes.get(key)){
                int par = uf.find(u);
                unionSize.put(par,unionSize.getOrDefault(par,0)+1);
            }
            
            for(int k : unionSize.keySet()){
                int val = unionSize.get(k);
                goodPaths +=(val*(val+1))/2;
            }
        }
        
        return goodPaths;
    }
}