//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    static final int R=0;
    static final int G=1;
    static final int B=2;
    public static long distinctColoring(int N, int[]r, int[]g, int[]b){
        //code here
        long[][] dp = new long[N][3];
        dp[0][R] = r[0];
        dp[0][G] = g[0];
        dp[0][B] = b[0];
        
        for(int i = 1 ; i < N ;i++){    
            dp[i][R]=r[i] + Math.min(dp[i-1][G], dp[i-1][B]);
            dp[i][G]=g[i] + Math.min(dp[i-1][B], dp[i-1][R]);
            dp[i][B]=b[i] + Math.min(dp[i-1][R], dp[i-1][G]);
        }
        return Math.min(dp[N-1][R],Math.min(dp[N-1][G],dp[N-1][B]));
    }
}


//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input[] = read.readLine().trim().split("\\s+");
            int[]r=new int[N];
            for(int i=0;i<N;i++)
                r[i]=Integer.parseInt(input[i]);
            input = read.readLine().trim().split("\\s+");
            int[]g=new int[N];
            for(int i=0;i<N;i++)
                g[i]=Integer.parseInt(input[i]);
            input = read.readLine().trim().split("\\s+");
            int[]b=new int[N];
            for(int i=0;i<N;i++)
                b[i]=Integer.parseInt(input[i]);

            Solution ob = new Solution();
            out.println(ob.distinctColoring(N, r, g, b));
        }
        out.close();
    }
}
// } Driver Code Ends