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
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




class Solution
{
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int vtces, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int mother=-1;
        boolean[] vis=new boolean[vtces];
        for(int v=0;v<vtces;v++){
            if(vis[v]==false){
                dfs(adj,v,vis);
                mother=v;
            }
        }
        
        vis=new boolean[vtces];
        dfs(adj,mother,vis);
        for(int v=0;v<vtces;v++){
            if(vis[v]==false)return -1;
        }
        return mother;
    }
    public void dfs(ArrayList<ArrayList<Integer>> graph , int src , boolean[] vis){
        vis[src]=true;
        for(int nbr:graph.get(src)){
            if(vis[nbr]==false){
                dfs(graph,nbr,vis);
            }
        }
    }
}