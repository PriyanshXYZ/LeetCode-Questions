class Solution {
    static class UnionFind {
        int[] p;
        int[] r;
        int comps = 0;
        
        UnionFind(int n){
            p = new int[n];
            r = new int[n];
            comps = n;
            for(int i = 0; i < p.length; i++){
                p[i] = i;
                r[i] = 0;
            }
        }
        
        int find(int x){
            if(p[x] == x){
                return x;
            } else {
                p[x] = find(p[x]);
                return p[x];
            }
        }
        
        boolean union(int X, int Y){
            int x = find(X);
            int y = find(Y);
            if(x == y){
                return false;
            }
            
            if(r[x] < r[y]){
                p[x] = y;
            } else if(r[y] < r[x]){
                p[y] = x;
            } else {
                p[y] = x;
                r[x]++;
            }
            comps--;
            
            return true;
        }
        
        boolean isConnected(){
            return comps == 1;
        }
    }
    
    static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int wt;
        
        Edge(int u, int v, int wt){
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
        
        public int compareTo(Edge o){
            return this.wt - o.wt;
        }
    }
    
    public int buildMST(int n, int[][] edges, int[] edgeToSkip, int[] edgeToPick){
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        
        for(int[] edge:edges){
            if(edge==edgeToSkip || edge==edgeToPick){
                continue;
            }
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];
            
            pq.add(new Edge(u,v,wt));
        }
        
        UnionFind uf=new UnionFind(n);
        int cost=0;
        
        if(edgeToPick!=null){
            uf.union(edgeToPick[0],edgeToPick[1]);
            cost+=edgeToPick[2];
        }
        
        while(pq.size()>0){
            Edge rem=pq.remove();
            if(uf.union(rem.u,rem.v)==false){
                continue;    
            }
            cost+=rem.wt;
        }
        
        if(uf.isConnected()){
            return cost;
        }else{
            return Integer.MAX_VALUE;        
        }
    }
    
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        //to build a MST 
        int minCost=buildMST(n,edges,null,null);
        
        List<Integer> critical =new ArrayList();
        List<Integer> pcritical=new ArrayList();
        
        for(int i=0;i<edges.length;i++){
            int[] edge=edges[i];
            //if excluding the edges results in more weight than MST=> it is a critical connection
            //if including the edges results in more weight than MST=> it is redundant connection
            //rest all would be pseudo critical edges
            
            int mstExcludingEdge = buildMST(n,edges,edge,null);
            if(mstExcludingEdge>minCost){
                critical.add(i);
            }else{
                int costIncludinhEdge =buildMST(n,edges,null,edge);
                if(costIncludinhEdge>minCost){
                    //redundant
                }else{
                    pcritical.add(i);
                }
            }
        }
        
        List<List<Integer>> res=new ArrayList();
        res.add(critical);
        res.add(pcritical);
        return res;
    }
}