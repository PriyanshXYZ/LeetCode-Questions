// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution
{
    static class Pair implements Comparable<Pair>{
        int u;
        int v;
        int wt;
        Pair(int u,int v,int wt){
            this.u=u;
            this.v=v;
            this.wt=wt;
        }
        
        public int compareTo(Pair other){
            return this.wt-other.wt;
        }
    }
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(0,-1,0));
        boolean[] vis=new boolean[V];
        int weight=0;
        while(!pq.isEmpty()){
            Pair rPair=pq.remove();
            
            if(vis[rPair.u]==true){
                continue;
            }
            vis[rPair.u]=true;
            weight+=rPair.wt;
            for(List<Integer> ele:adj.get(rPair.u)){
                int v=ele.get(0);
                int wt=ele.get(1);
                pq.add(new Pair(v,rPair.u,wt));
            }
        }
        return weight;
    }
}
