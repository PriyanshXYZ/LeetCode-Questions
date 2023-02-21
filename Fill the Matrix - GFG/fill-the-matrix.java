//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    
	public static int minIteration(int N, int M, int x, int y){
		//code here
	    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
	    Queue<int[]> q = new ArrayDeque<>();
	    q.add(new int[]{x-1,y-1});
	    
	    boolean[][] vis = new boolean[N][M];
	    vis[x-1][y-1]=true;
	    int time = 0;
	    int left = N*M;
	    while(q.size()>0){
	        int size = q.size();
	        while(size-->0){
	            int[] rem = q.remove();
	            int r = rem[0];
	            int c = rem[1];
	            left--;
	            if(left==0)return time;
	            for(int[] dir : dirs){
	                int xx = r + dir[0];
	                int yy = c + dir[1];
	                if( isValid(N,M,xx,yy) && vis[xx][yy]==false){
	                    q.add(new int[]{xx,yy});
	                    vis[xx][yy]=true;
	                }
	            }
	        }
	        time++;
	    }
	    return -1;
	}
	public static boolean isValid(int n, int m, int x, int y){
	    if(x>=0 && y>=0 && x<n && y<m)return true;
	    return false;

	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String input[]=read.readLine().trim().split(" ");
            int N = Integer.parseInt(input[0]);
            int M=Integer.parseInt(input[1]);
           	input=read.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.minIteration(N, M, x, y));
        }
        
    }
}
// } Driver Code Ends