class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        HashSet<Integer>[] graph =new HashSet[n];
        
        for(int i=0;i<n;i++){
            graph[i]=new HashSet();
        }
        
        //creating a graph
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            
            graph[u].add(v);
            graph[v].add(u);
        }
        int[] nodes=new int[n];
        int[] res=new int[n];
        
        helper1(graph,nodes,res,0,-1);
        helper2(graph,nodes,res,0,-1);
        return res;
    }
    private void helper1(HashSet<Integer>[] graph,int[] nodes,int[] res,int src,int parent){
        
        for(int nbr:graph[src]){
            if(nbr!=parent){
                helper1(graph,nodes,res,nbr,src);
                nodes[src]+=nodes[nbr];//to add descendants count
                res[src]+=nodes[nbr]+res[nbr];
            }
        }
        nodes[src]++;//to add self count
    }
    private void helper2(HashSet<Integer>[] graph,int[] nodes,int[] res,int src,int parent){
        for(int nbr:graph[src]){
            if(nbr!=parent){
                res[nbr]=res[src]+(nodes.length-nodes[nbr])-(nodes[nbr]);
                helper2(graph,nodes,res,nbr,src);
            }
        }
    }
}