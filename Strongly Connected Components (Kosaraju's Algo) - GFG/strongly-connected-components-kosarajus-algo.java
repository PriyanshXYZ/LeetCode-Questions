// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int vtces, ArrayList<ArrayList<Integer>> graph)
    {
        //code here
        //1. dfs through all the components
        //2. in post order add them in a stack
        //3. transpose the graph
        //4. pop from stack and components which come out with each dfs are the no of required components
        
        Stack<Integer> stk=new Stack<>();
        boolean[] visited=new boolean[vtces];
        //1. dfs through all the components
        for(int u=0;u<vtces;u++){
            if(visited[u]!=true){
                dfs(graph,u,stk,visited);
            }
        }
        
        //3. transpose the graph
        ArrayList<ArrayList<Integer>> transpose=new ArrayList<>();
        for(int i=0;i<vtces;i++){
            transpose.add(new ArrayList<>());
        }
        
        for(int u=0;u<vtces;u++){
            for(int v=0;v<graph.get(u).size();v++){
                transpose.get(graph.get(u).get(v)).add(u);
            }
        }
        
        boolean[] visited2=new boolean[vtces];
        int scc=0;//strongly connected comp
        //4. pop from stack
        while(stk.size()!=0){
            int u=stk.pop();
            if(visited2[u]==false){
                dfs(transpose,u,visited2);
                scc++;
            }
        }
        return scc;
    }
    public void dfs(ArrayList<ArrayList<Integer>> graph,int src,boolean[] vis){
        vis[src]=true;
        for(int nbr:graph.get(src)){
            if(vis[nbr]==false){
                dfs(graph,nbr,vis);
            }
        }
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> graph,int src,Stack<Integer> stk,boolean[] vis){
        vis[src]=true;
        for(int nbr:graph.get(src)){
            if(vis[nbr]==false){
                dfs(graph,nbr,stk,vis);
            }
        }
        //2. in post order add them in a stack
        stk.push(src);
    }
}
