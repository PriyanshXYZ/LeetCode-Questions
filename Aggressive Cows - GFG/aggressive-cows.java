//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        
        int lo = 0;
        int hi = stalls[n-1] - stalls[0];
        
        int ans = -1;
        while(lo<=hi){
            int minDist = lo + (hi - lo)/2;
            
            int aggresiveCows = 1;
            int lastPlacedCow = stalls[0];
            for(int i = 1; i<n;i++){
                if(stalls[i] - lastPlacedCow >= minDist){
                    aggresiveCows++;
                    lastPlacedCow = stalls[i];
                }
            }
            
            if(aggresiveCows >= k){
                //more agressive cows we need to increse distance
                
                lo = minDist + 1;
            }else{
                //less agressive cows we need to check if for more min distance can we get the lesser cows
                ans = minDist - 1;
                hi = minDist - 1;
            }
        }
        return ans;
    }
}