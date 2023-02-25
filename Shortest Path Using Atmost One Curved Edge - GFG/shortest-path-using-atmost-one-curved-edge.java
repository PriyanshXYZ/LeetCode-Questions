//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            int a = Integer.parseInt(S1[0]);
            int b = Integer.parseInt(S1[1]);
            
            ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
            
            for(int i=0; i<m; i++)
            {
                String S2[] = read.readLine().split(" ");
                int u = Integer.parseInt(S2[0]);
                int v = Integer.parseInt(S2[1]);
                int x = Integer.parseInt(S2[2]);
                int y = Integer.parseInt(S2[3]);
                
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(u);
                edge.add(v);
                edge.add(x);
                edge.add(y);
                
                edges.add(edge);
            }

            Solution ob = new Solution();
            System.out.println(ob.shortestPath(n,m,a,b,edges));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int shortestPath(int n, int m, int a, int b, ArrayList<ArrayList<Integer>> edges) {
        // code here
        List<List<int[]>> graph = new ArrayList<>();
        List<int[]> curved = new ArrayList<>();
        
        for(int i=0;i<=n;i++)graph.add(new ArrayList<>());
        
        for(ArrayList<Integer> e : edges){
            int u = e.get(0);
            int v = e.get(1);
            int wt = e.get(2);
            int cwt = e.get(3);
            
            graph.get(u).add(new int[]{v,wt});
            graph.get(v).add(new int[]{u,wt});
            
            curved.add(new int[]{u,v,cwt});
        }
        
        int[] distFromA = dijsktra(a,b,graph,n);
        int[] distFromB = dijsktra(b,a,graph,n);
        
        int minDist = distFromA[b];
        
        for(int i=0;i<m;i++){
            int u = curved.get(i)[0];
            int v = curved.get(i)[1];
            int cwt = curved.get(i)[2];
            int distUV = distFromA[u]+cwt+distFromB[v];
            int distVU = distFromA[v]+cwt+distFromB[u];
            
            minDist = Math.min(distUV,minDist);
            minDist = Math.min(distVU,minDist);
        }
        
        if(minDist>=1e9)return -1;
        return minDist;
    }
    static int[] dijsktra(int src, int dest, List<List<int[]>> graph,int vtces){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));//a[0]-> node a[1]->totalDistFrom src to curr node
        
        
        int[] dist = new int[vtces+1];
        
        Arrays.fill(dist,(int)(1e9));
        
        pq.add(new int[]{src,0});
        
        dist[src]=0;
        
        while(!pq.isEmpty()){
            int[] rem = pq.remove();
            int node = rem[0];
            int dis = rem[1];
            
            if(dist[node]<dis)continue;
            dist[node]=dis;
            
            for(int[] a : graph.get(node)){
                int nbr = a[0];
                int d = a[1] + dis;
                
                pq.add(new int[]{nbr,d});    
                
                
            }
        }
        return dist;
    }
};