class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] p=new int[n+1];
        int[] r=new int[n+1];
        
        
        for(int i=0;i<=n;i++){
            p[i]=i;
        }
        
        
        int redundant=0;
        int aliceEdges=0;
        int bobEdges=0;
        //adding the type 3 nodes as it is useful for both
        for(int[] edge:edges){
            if(edge[0]==3){
                
                boolean didUnionHappen=union(p,r,edge[1],edge[2]);
                if(didUnionHappen==false){
                    redundant++;
                }else{
                    aliceEdges++;
                    bobEdges++;
                }
            }
        }
        
        int[] p1=p.clone();
        int[] r1=r.clone();
        //adding alice's edges
        for(int[] edge:edges){
            if(edge[0]==1){
                
                boolean didUnionHappen=union(p1,r1,edge[1],edge[2]);
                if(didUnionHappen==false){
                    redundant++;
                }else{
                    //only alice edges will be made with this
                    aliceEdges++;
                }
            }
        }
        
        
        int[] p2=p.clone();
        int[] r2=r.clone();
        //adding bob's edges
        for(int[] edge:edges){
            if(edge[0]==2){
                
                boolean didUnionHappen=union(p2,r2,edge[1],edge[2]);
                if(didUnionHappen==false){
                    redundant++;
                }else{
                    //only alice edges will be made with this
                    bobEdges++;
                }
            }
        }
        
        if(aliceEdges!=n-1 || bobEdges!=n-1){
            return -1;
        }
        return redundant;
    }
    
    int find(int[] p,int x){
        if(p[x]==x){
            return x;
        }else{
            p[x]=find(p,p[x]);
            return p[x];
        }
    }
    
    boolean union(int[] p,int[] r,int x,int y){
        int xl=find(p,x);
        int yl=find(p,y);
        
        
        if(xl==yl){
            return false;
        }else{
            if(r[xl]>r[yl]){
                p[yl]=xl;
            }else if(r[yl]>r[xl]){
                p[xl]=yl;
            }else{
                p[xl]=yl;
                r[yl]++;
            }
            return true;
        }
    }
}