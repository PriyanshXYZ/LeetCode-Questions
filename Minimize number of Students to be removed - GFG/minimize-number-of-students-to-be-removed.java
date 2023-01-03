//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] H = new int[N];
            
            for(int i=0; i<N; i++)
                H[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.removeStudents(H,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int removeStudents(int[] H, int N) {
        // code here
        int[] dp = new int[N+1];
        
        dp[0]=H[0];
        int len = 1;
        for(int i = 1;i<N;i++){
            if(H[i]>dp[len-1]){
                len++;
                dp[len-1] = H[i];
            }else{
                int idx = Arrays.binarySearch(dp,0,len - 1, H[i]);
                
                if(idx<0){
                    idx = -idx - 1;
                }
                dp[idx] = H[i];
            }
        }
        return N-len;
    }
};