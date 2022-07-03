// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.isBridge(V,list,c,d));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        // code here
        time=0;
        res=0;
        
        boolean[] vis=new boolean[V];
        int[] discovery=new int[V];
        int[] lowestDis=new int[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                dfs(adj,vis,discovery,lowestDis,i,-1,c,d);
            }
        }
        return res;
    }
    static int time;
    static int res;
    
    private static void dfs(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int[] discovery,int[] lowestDis,int u,int par,int c,int d){
        discovery[u]=time;
        lowestDis[u]=time;
        vis[u]=true;
        time++;
        
        for(int v:adj.get(u)){
            if(v==par){
                continue;
            }else if(vis[v]==true){
                lowestDis[u]=Math.min(discovery[v],lowestDis[u]);
            }else{
                dfs(adj,vis,discovery,lowestDis,v,u,c,d);
                lowestDis[u]=Math.min(lowestDis[v],lowestDis[u]);
                
                if(lowestDis[v] > discovery[u]){//for bridge lowest must be strictly greater
                    if((c==u && d==v )||(c==v && d==u)){
                        res=1;
                    }
                }
            }
        }
    }
}