// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] vis=new int[V];
        int[] dfsVis=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                boolean cycle=detectCycle(adj,i,vis,dfsVis);
                if(cycle)return true;
            }
        }
        return false;
    }
    private boolean detectCycle(ArrayList<ArrayList<Integer>> adj,int src,int[] vis,int[] dfsVis){
        if(vis[src]==1){
            if(dfsVis[src]==1)
                return true;
            else return false;
        }else{
            vis[src]=1;
            for(int nbr :adj.get(src)){
                dfsVis[src]=1;
                boolean flag=detectCycle(adj,nbr,vis,dfsVis);
                if(flag)return true;
                dfsVis[src]=0;
            }
        }
        return false;
    }
}