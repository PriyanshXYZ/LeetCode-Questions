// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S1 = br.readLine().trim().split(" ");
            int n  = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    matrix[i][j] = Integer.parseInt(S2[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.longestIncreasingPath(matrix);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int[] dx={-1,0,1,0};
    int[] dy={0,1,0,-1};
    public int longestIncreasingPath(int[][] matrix)
    {
        // Code here 
        int n=matrix.length;
        int m=matrix[0].length;
        int maxPath=0;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
            maxPath=Math.max(maxPath,memo(i,j,n,m,matrix,dp));        
            }
        }
        return maxPath;
    }
    public int recursion(int r,int c,int mr,int mc,int[][] matrix){
        
        int path=1;
        for(int i=0;i<4;i++){
            int x=r+dx[i];
            int y=c+dy[i];
            
            if(x>=0 && y>=0 && x<mr && y<mc && matrix[x][y]>matrix[r][c]){
                int ans=recursion(x,y,mr,mc,matrix);
                path=Math.max(path,1+ans);
            }
        }
        return path;
    }
    public int memo(int r,int c,int mr,int mc,int[][] matrix,int[][] dp){
        
        if(dp[r][c]!=0)return dp[r][c];
        int path=1;
        for(int i=0;i<4;i++){
            int x=r+dx[i];
            int y=c+dy[i];
            
            if(x>=0 && y>=0 && x<mr && y<mc && matrix[x][y]>matrix[r][c]){
                int ans=memo(x,y,mr,mc,matrix,dp);
                path=Math.max(path,1+ans);
            }
        }
        return dp[r][c]=path;
    }
}