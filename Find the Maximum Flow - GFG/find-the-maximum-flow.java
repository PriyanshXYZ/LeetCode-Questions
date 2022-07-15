// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
    
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
            input_line = read.readLine().trim().split("\\s+");
            for(int i=0;i<M;i++)
            {
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[3*i]));
                e.add(Integer.parseInt(input_line[3*i+1]));
                e.add(Integer.parseInt(input_line[3*i+2]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            int ans = ob.findMaxFlow(N, M, Edges); 
            System.out.println(ans);
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int findMaxFlow(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        // code here
        int[][] graph=new int[N+1][N+1];
        int[][] resGraph=new int[N+1][N+1];
        
        for(List<Integer> edge : Edges){
            int u=edge.get(0);
            int v=edge.get(1);
            int wt=edge.get(2);
            
            graph[u][v]+=wt;
            graph[v][u]+=wt;
            
            resGraph[u][v]+=wt;
            resGraph[v][u]+=wt;
        }
        int maxFlow=0;
        boolean[] vis=new boolean[N+1];
        int[] par=new int[N+1];
        while(dfs(resGraph,par,1,N,vis)==true){
            int flow=Integer.MAX_VALUE;
            
            int v=N;
            //to get maximum possible flow
            while(v!=1){
                int pv=par[v];
                int pathFlow=resGraph[pv][v];
                if(pathFlow<flow){
                    flow=pathFlow;
                }
                
                v=pv;
            }
            
            v=N;
            //to get update the edges of already flown value;
            while(v!=1){
                int pv=par[v];
                resGraph[pv][v]-=flow;
                resGraph[v][pv]+=flow;
                
                v=pv;
            }
            maxFlow+=flow;
            vis=new boolean[N+1];
        }
        return maxFlow;
    }
    boolean dfs(int[][] resGraph,int[] par,int src,int dest,boolean[] vis){
        vis[src]=true;
        if(src==dest){
            return true;
        }
        
        for(int nbr=1;nbr<resGraph.length;nbr++){
            if(vis[nbr]==false && resGraph[src][nbr]>0){
                par[nbr]=src;
                boolean isPathFound=dfs(resGraph,par,nbr,dest,vis);
                
                if(isPathFound)return true;
            }
        }
        return false;
    }
}