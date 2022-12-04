class Solution {
    class Pair implements Comparable<Pair>{
        int node;
        int score;
        Pair(int node,int score){
            this.node=node;
            this.score=score;
        }
        public int compareTo(Pair o){
            return this.score-o.score;
        }
        public String toString(){
            return node+" "+score;
        }
    }
    public int minScore(int n, int[][] roads) {
        //if whole network is connected return min of whole network
        //if not then return smallest edge between 1 to n
        //to check if whole is connected or not we use DSU
        
        List<List<Pair>> graph=new ArrayList();
        for(int i=0;i<=n;i++)graph.add(new ArrayList());
        for(int[] road:roads){
            int u=road[0];
            int v=road[1];
            int dist=road[2];

            graph.get(u).add(new Pair(v,dist));
            graph.get(v).add(new Pair(u,dist));
        }
        Queue<Pair> q=new ArrayDeque();
        HashSet<Integer> vis=new HashSet();
        q.add(new Pair(1,0));
        int min=Integer.MAX_VALUE;
        while(q.size()>0){
            Pair rem=q.remove();
            if(!vis.contains(rem.node)){
                for(Pair nbr:graph.get(rem.node)){
                    int scr=nbr.score;
                    q.add(new Pair(nbr.node,scr));
                    min=Math.min(min,scr);    
                }
            }
            vis.add(rem.node);
        }
        return min;
    }
//     int[] par;
//     int[] rank;
//     int[] minSz;
    
//     public int find(int x){
//         if(par[x]==x)return x;
//         par[x]=find(par[x]);
//         return par[x];
//     }
//     public void union(int s1Lead,int s2Lead){
//         if(rank[s1Lead]<rank[s2Lead]){
//             par[s1Lead]=s2Lead;
//         }else if(rank[s2Lead]<rank[s1Lead]){
//             par[s2Lead]=s1Lead;
//         }else{  
//             par[s2Lead]=s1Lead;
//             rank[s1Lead]++;
     
//         }
//     }
}
