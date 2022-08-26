class Solution {
    class Pair{
        int nbr;
        int wt;
        
        Pair(int nbr,int wt){
            this.nbr=nbr;
            this.wt=wt;
        }
    }
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        //create graph
        List<List<Pair>> graph=new ArrayList();
        for(int val:values)graph.add(new ArrayList());
        for(int[] edge : edges){
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];    
            graph.get(u).add(new Pair(v,wt));
            graph.get(v).add(new Pair(u,wt));
        }
        score=0;
        int[] vis=new int[values.length];
        dfs(0,0,0,graph,values,vis,maxTime);
        return score;
    }
    int score;
    public void dfs(int src,int time,int res,List<List<Pair>> graph,int[] values,int[] vis,int maxTime){
        if(time>maxTime)return;
        
        if(vis[src]==0)//first visit 
            res+=values[src];
        
        vis[src]++;
        
        if(src==0){
            score=Math.max(res,score);
        }
        
        
        for(Pair p : graph.get(src)){
            int nbr=p.nbr;
            int newTime=p.wt+time;
            // System.out.println(src+"->"+nbr);
            dfs(nbr,newTime,res,graph,values,vis,maxTime);
            // System.out.println(src+"<-"+nbr);
        }
        vis[src]--;
    }
}