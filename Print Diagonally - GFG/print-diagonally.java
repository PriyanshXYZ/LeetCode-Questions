//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.downwardDigonal(n, matrix);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<Integer> downwardDigonal(int N, int A[][])
    {
        // code here 
        int r=0,c=0;
        ArrayList<Integer> res=new ArrayList<>();
        while(c<N){
            for(int row=0,col=c;col>=0;row++,col--){
                res.add(A[row][col]);
            }
            c++;
        }
        r=1;
        while(r<N){
            for(int row=r,col=N-1;row<=N-1;row++,col--){
                res.add(A[row][col]);
            }
            r++;
        }
        return res;
    }
}
