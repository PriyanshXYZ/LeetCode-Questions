//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int splitArray(int[] nums , int N, int k) {
        // code here
        int lo=Integer.MIN_VALUE;
        int hi=0;
        for(int val : nums){
            hi += val;
            lo = Math.max(val, lo);
        }
        
        while(lo < hi){
            int sum = lo + (hi - lo) / 2;
            
            int count = 1;
            int curSum = 0;
            for(int val : nums){
                if(val + curSum <= sum){
                    curSum+=val;
                }else{
                    curSum=val;
                    count++;
                }
            }
            
            if(count > k){
                lo = sum + 1;
            }else{
                hi = sum;
                
            }
        }
        return lo;
    }
};