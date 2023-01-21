//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            out.println(ob.minVal(a, b));
        }
        out.flush();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int countSetBits(int n){
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
    public static int minVal(int a, int b) {
        // code here
        int abit = countSetBits(a);
        int bbit = countSetBits(b);
        
        if(abit==bbit){
            return a;
        }else{
            int ans = 0;
            for(int i = 0; i<32 ;i++){
                int mask = (1<<i);
                int set1 = a & mask;
                if(set1 == 0 && bbit > abit){
                    ans = ans | mask;
                    bbit--;
                }else if(set1!=0 && abit>bbit){
                    abit--;
                }else{
                    ans = ans | set1;
                }
            }
            return ans;
        }
    }
}