class Solution {
    class UF{
        int[] parent;
        int[] rank;
        int[] size;

        UF(int n){
            this.parent = new int[n];
            this.rank = new int[n];
            this.size = new int[n];
            
            for(int i = 0; i < n; i++){
                parent[i]=i;
            }
        }
        int find(int x){
            if(parent[x] != x){
                return find(parent[x]);
            }
            return x;
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

    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)return -1;
        int components = n;
        
        UF uf = new UF(n);
        
        for(int[] e : connections){
            int u = e[0];
            int v = e[1];
            
            int s1Lead = uf.find(u);
            int s2Lead = uf.find(v);
            
            if(s1Lead !=s2Lead){
                uf.union(s1Lead,s2Lead);
                components--;
            }
        }
        return components - 1;
    }
}