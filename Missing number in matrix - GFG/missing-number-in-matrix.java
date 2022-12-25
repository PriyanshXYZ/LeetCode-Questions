//{ Driver Code Starts
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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            long ans = ob.MissingNo(matrix);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long  MissingNo(int[][] matrix)
    {
        // code here
        int n = matrix.length;
        long ans = 0;
        int x0=0,y0=0;
        
        long[] rowSum = new long[n];
        long[] colSum = new long[n];    
        
        long leftDiagSum = 0;
        long rightDiagSum = 0;
        
        for(int i=0;i<n;i++){
            leftDiagSum += matrix[i][i];
            rightDiagSum += matrix[i][n-1-i];
            
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0){
                    x0 = i;
                    y0 = j;
                }
                rowSum[i] += matrix[i][j];
                colSum[j] += matrix[i][j];
            }
        }
        
        long colReqSum = y0 != 0 ? colSum[y0 - 1] : colSum[y0 + 1];
        long rowReqSum = x0 != 0 ? rowSum[x0 - 1] : rowSum[x0 + 1];
        long diff = colReqSum - colSum[y0];
        
        if(diff <= 0 || diff != rowReqSum - rowSum[x0]) {
            return -1;
        }
        
        if(x0 == y0) {
            leftDiagSum += diff;
        }
        
        if(x0 == (n - y0 - 1)) {
            rightDiagSum += diff;
        }
        
        if(leftDiagSum != rightDiagSum) {
            return -1;
        }
        
        rowSum[x0] += diff;
        colSum[y0] += diff;
        
        for(long num : rowSum) {
            if(num != leftDiagSum) {
                return -1;
            }
        }
        
        for(long num : colSum) {
            if(num != rightDiagSum) {
                return -1;
            }
        }
        
        return diff;
    }
}