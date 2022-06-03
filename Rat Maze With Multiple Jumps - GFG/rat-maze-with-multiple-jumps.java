// { Driver Code Starts
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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int[][] ans = ob.ShortestDistance(matrix);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    
    public int[][] ShortestDistance(int[][] matrix)
    {
        // Code here
        
        int n=matrix.length;
        
        int[][] ans=new int[n][n];
        if(recursion(matrix,ans,n,0,0)){
            return ans;
        }
        return new int[][]{{-1}};
    }
    public boolean recursion(int[][] mat,int[][] res,int n,int r,int c){
        //base case
        if(r==n-1 && c==n-1){
            res[r][c]=1;
            return true;
        }
        int val=mat[r][c];
        res[r][c]=1;
        for(int jumps=1;jumps<=val;jumps++){
            //since forward jump is preferred we perform it first
            if(c+jumps<n){
                if(recursion(mat,res,n,r,c+jumps)){
                    return true;
                }
            }
            if(r+jumps<n){
                if(recursion(mat,res,n,r+jumps,c))
                    return true;
            }
            
        }
        res[r][c]=0;
        return false;
    }
}