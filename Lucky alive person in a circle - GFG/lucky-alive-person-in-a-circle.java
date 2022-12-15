//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java

class Solution{
    static int find(int N){
        // code here
        return f(N,2)+1;
    }
    public static int f(int n, int k){
        if(n==1)return 0;
        return (f(n-1,k)+k)%n;
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
            int N = Integer.parseInt(read.readLine());
           
            Solution ob = new Solution();
            System.out.println(ob.find(N));
        }
    }
}
// } Driver Code Ends