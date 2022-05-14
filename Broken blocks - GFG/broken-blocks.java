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
            String[] S = br.readLine().trim().split(" ");
            int m = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);
            int[][] matrix = new int[m][n];
            for(int i = 0; i < m; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            int ans = obj.MaxGold(matrix);
            System.out.println(ans);

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int MaxGold(int[][] matrix)
    {
        // Code here
        int max=Integer.MIN_VALUE;
        int[][] dp=new int[matrix.length][matrix[0].length];
        
        for(int c=0;c<matrix[0].length;c++){
            max=Math.max(max,memo(0,c,matrix.length,matrix[0].length,matrix,dp));
        }
        // for(int c=0;c<matrix[0].length;c++){
        //     max=Math.max(max,recursion(0,c,matrix.length,matrix[0].length,matrix,0));
        // }
        return max;
    }
    public int recursion(int r,int c,int maxRow,int maxCol,int[][] mat){
        if(r>=maxRow || c<0 || c>=maxCol || mat[r][c]==-1 )return 0;
        
        
        int left=0,down=0,right=0;
            
        //down left
        left=recursion(r+1,c-1,maxRow,maxCol,mat);
        //down
        down=recursion(r+1,c,maxRow,maxCol,mat);
        //down right
        right=recursion(r+1,c+1,maxRow,maxCol,mat);
            
        return Math.max(left,Math.max(down,right))+mat[r][c];
    }
    
    public int memo(int r,int c,int maxRow,int maxCol,int[][] mat,int[][] dp){
        if(r>=maxRow || c<0 || c>=maxCol || mat[r][c]==-1 )return 0;
        
        int left=0,down=0,right=0;
        if(dp[r][c]!=0)return dp[r][c];
        //down left
        left=memo(r+1,c-1,maxRow,maxCol,mat,dp);
        //down
        down=memo(r+1,c,maxRow,maxCol,mat,dp);
        //down right
        right=memo(r+1,c+1,maxRow,maxCol,mat,dp);
            
        return dp[r][c]=mat[r][c]+Math.max(left,Math.max(down,right));
    }
}