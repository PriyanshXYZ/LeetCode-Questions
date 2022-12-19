//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.maxGcd(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long maxGcd(int N) {
        // code here
        return Math.max(lcm(N),lcm(N-1));
    }
    long lcm(long n){
        long num = n;
        int include = 0;
        for(long i = n - 1 ; i > 0; i--){
            long g = gcd(i,num);
            if(g == 1){
                num *= i;
                include++;
            }
            if(include == 3)return num;
        }
        return num;
    }
    long gcd(long a , long b){
        if(a == 0)return b;
        return gcd(b % a , a);
    }
}