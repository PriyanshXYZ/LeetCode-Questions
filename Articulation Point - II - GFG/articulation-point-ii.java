// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int[] ans = obj.articulationPoints(V, adj);
            for(int i: ans)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


class Solution
{
    public int[] articulationPoints(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        
        HashSet<Integer> set=new HashSet<>();
        int[] dis=new int[V];//duration at which it got visited.or discovery of node
        int[] low=new int[V];//lowest duration which it vertice can go.
        boolean[] vis=new boolean[V];
        
        for(int v=0;v<V;v++){
            if(vis[v]==false){
                dfs(adj,set,dis,low,vis,v,-1,0);
            }
        }
        if(set.size()>0){
            int[] res=new int[set.size()];
            int idx=0;
            for(int val: set){
                res[idx++]=val;
                
            }
            Arrays.sort(res);
            return res;
        }else{
            return new int[]{-1};
        }
    }
    private void dfs(ArrayList<ArrayList<Integer>> adj,HashSet<Integer> artiPoint,int[] dis,int[] low,boolean[] vis,int src,int par,int level){
        vis[src]=true;
        dis[src]=level;
        low[src]=level;
        
        
        int child=0;
        for(int nbr:adj.get(src)){
            if(nbr==par){
                continue;
            }
            else if(vis[nbr]==true){
                low[src]=Math.min(low[src],dis[nbr]);
            }else{
                child++;
                dfs(adj,artiPoint,dis,low,vis,nbr,src,level+1);
                low[src]=Math.min(low[src],low[nbr]);
                
                if(par!=-1 && low[nbr]>=dis[src]){
                    artiPoint.add(src);
                }
            }
        }
        
        if(par==-1 && child>1){
            artiPoint.add(src);
        }
    }
}