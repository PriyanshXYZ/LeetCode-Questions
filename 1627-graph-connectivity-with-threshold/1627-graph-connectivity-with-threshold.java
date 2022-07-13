class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        parent=new int[n+1];
        rank=new int[n+1];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int div=threshold+1;div<=n;div++){
            for(int i=1;i*div<=n;i++){
                unionHelper(div,i*div);
            }
        }
        
        List<Boolean> res=new ArrayList();
        for(int[] query:queries){
            int lead1=find(query[0]);
            int lead2=find(query[1]);
            
            if(lead1==lead2){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;
    }
    int[] rank;
    int[] parent;
    
    private void unionHelper(int x,int y){
        int xlead=find(x);
        int ylead=find(y);
        
        if(xlead!=ylead){
            union(xlead,ylead);
        }
    }
    private int find(int x){
        if(parent[x]==x){
            return x;
        }else{
            parent[x]=find(parent[x]);
            return parent[x];
        }
    }
    
    private void union(int lead1,int lead2){
        if(rank[lead1]>rank[lead2]){
            parent[lead2]=lead1;
        }else if(rank[lead2]>rank[lead1]){
            parent[lead1]=lead2;
        }else{
            parent[lead2]=lead1;
            rank[lead1]++;
        }
    }
}