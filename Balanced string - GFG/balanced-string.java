//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Position this line where user code will be pasted.
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.BalancedString(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    static String BalancedString(int N) {
        // code here
        int temp = sod(N);
        String str = "";
        while(N > 26){
            str += "abcdefghijklmnopqrstuvwxyz";
            N -= 26;
        }
        // System.out.println(N);
        if(N % 2 ==0){
            for(int i=0 ;i<(N) / 2; i++){
                str += (char)(i+'a');
            }
            
            for(int i=(N) / 2;i > 0; i--){
                str += (char)(26 - i+'a');
            }
        }else{
            
            if(temp % 2 == 0){
                for(int i=0 ;i<(N + 1) / 2; i++){
                    str += (char)(i+'a');
                }
                
                for(int i=(N - 1) / 2;i > 0; i--){
                    str += (char)(26 - i+'a');
                }    
            }else{
                for(int i=0 ;i<(N - 1) / 2; i++){
                    str += (char)(i+'a');
                }
                
                for(int i=(N + 1) / 2;i > 0; i--){
                    str += (char)(26 - i+'a');
                }
            }
            
        }
        
        return str;
    }
    static int sod(int n){
        int sum=0;
        while(n > 0){
            sum += n%10;
            n=n/10;
        }
        return sum;
    }
}