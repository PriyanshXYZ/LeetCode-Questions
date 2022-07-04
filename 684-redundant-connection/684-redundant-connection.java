class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent=new int[n+1];
        rank=new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }
        
        for(int i=0;i<n;i++){
            int xLead=find(edges[i][0]);
            int yLead=find(edges[i][1]);
            
            if(xLead!=yLead){
                union(xLead,yLead);
            }else{
                return new int[]{edges[i][0],edges[i][1]};
            }
        }
        return new int[]{};
    }
    int[] parent;
    int[] rank;
    
    int find(int x){
        if(parent[x]==x){
            return x;
        }else{
            int pofx=parent[x];
            parent[x]=find(pofx);
            return parent[x];
        }
    }
    
    void union(int s1Lead,int s2Lead){
        if(rank[s1Lead]<rank[s2Lead]){
            parent[s1Lead]=s2Lead;
        }else if(rank[s2Lead]<rank[s1Lead]){
            parent[s2Lead]=s1Lead;
        }else{
            parent[s1Lead]=s2Lead;
            rank[s2Lead]++;
        }
    }
}