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
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int uniquePaths(int n, int m, int[][] grid) {
        // code here
        int mod = (int)(1e9+7);
        if(grid[0][0]==0 || grid[n-1][m-1]==0)return 0;
        int[] dp = new int[m];
        
        dp[0]=grid[0][0]==1?1:0;
        for(int i=1;i<m;i++){
            dp[i] = grid[0][i]==1?dp[i-1]:0;
        }
        
        for(int i=1;i<n;i++){
            int[] curr = new int[m];
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    if(j>0)
                        curr[j] = (curr[j]%mod + curr[j-1]%mod)%mod;
                    curr[j]= (curr[j]%mod + dp[j]%mod) % mod;    
                }
                
            }
            dp=curr;
        }
        return dp[m-1];
    }
};