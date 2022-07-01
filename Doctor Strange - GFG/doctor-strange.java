// { Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
    
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
	    Complete obj = new Complete();
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int N = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    int arr [][] = new int[K][2];
		    for(int i = 0;i<K;i++){
	            line = br.readLine();
		        String[] elements = line.trim().split("\\s+");
		        arr[i][0] = Integer.parseInt(elements[0]);
		        arr[i][1] = Integer.parseInt(elements[1]);    
	        }
            int ans = obj.doctorStrange(N, K, arr);
            System.out.println(ans);
    	    
		}
	}
}



// } Driver Code Ends


//User function Template for Java

//User function Template for Java


class Complete{
    //similar to articulation point....
    // Function for finding maximum and value pair
    public static int doctorStrange (int n, int k, int g[][]) {
        //Complete the function
        
        //creating a graph
        ArrayList<Integer>[] adj=(ArrayList<Integer>[])new ArrayList[k+2];
        for(int i=0;i<=k+1;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<k;i++){
            int u=g[i][0];
            int v=g[i][1];
            
            adj[u].add(v);
            adj[v].add(u);
        }
        int len=adj.length;
        HashSet<Integer> artiPoint=new HashSet<>();
        int[] discovery=new int[len];
        int[] leastDis=new int[len];
        boolean[] vis=new boolean[len];
        
        for(int v=1;v<=k;v++){
            if(vis[v]==false){
                dfs(adj,vis,discovery,leastDis,artiPoint,v,-1,0);
            }
        }
        
        return artiPoint.size();
    }
    
    public static void dfs(ArrayList<Integer>[] adj,boolean[] vis,int[] discovery,int[] leastDis,HashSet<Integer> artiPoints,int u,int par,int level){
        discovery[u]=level;
        leastDis[u]=level;
        vis[u]=true;
        
        
        int child=0;
        for(int v : adj[u]){
            if(v==par){
                continue;
            }else if(vis[v]==true){
                leastDis[u]=Math.min(leastDis[u],discovery[v]);
            }else{
                child++;
                dfs(adj,vis,discovery,leastDis,artiPoints,v,u,level+1);
                
                leastDis[u]=Math.min(leastDis[u],leastDis[v]);
                
                if(par!=-1 && leastDis[v]>=discovery[u]){
                    artiPoints.add(u);
                }
            }
        }
        
        if(par==-1 && child>1){
            artiPoints.add(u);
        }
    }
    
    
}