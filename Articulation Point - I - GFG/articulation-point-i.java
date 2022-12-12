//{ Driver Code Starts
// Initial Template for Java
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
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        dis = new int[V];
        low = new int[V];
        HashSet<Integer> set = new HashSet<>();
        boolean[] vis = new boolean[V];
        time=0;
        for(int i=0; i < V; i++){
            if(!vis[i])dfs(0, -1, adj, set, vis);
        }
        if(set.size()>0){
            ArrayList<Integer> res = new ArrayList<>(set);
            Collections.sort(res);
            return res;
        }else{
            ArrayList<Integer> res = new ArrayList<>();
            res.add(-1);
            return res;
        }
    }
    int time;
    public void dfs(int node, int par, ArrayList<ArrayList<Integer>> adj, HashSet<Integer> set, boolean[] vis){
        vis[node]=true;
        dis[node]=time;
        low[node]=time;
        time++;
        int child=0;
        for(int nbr : adj.get(node)){
            if(nbr == par)continue;
            else if(vis[nbr]){
                low[node] = Math.min(dis[nbr],low[node]);
            }else{
                child++;
                dfs(nbr, node, adj, set, vis);
                low[node] = Math.min(low[node], low[nbr]);
                
                if(par!=-1 && low[nbr] >= dis[node]){
                    set.add(node);
                }
            }
        }
        if(par==-1 && child>1){
            set.add(node);
        }
    }
    static int[] dis;
    static int[] low;
}