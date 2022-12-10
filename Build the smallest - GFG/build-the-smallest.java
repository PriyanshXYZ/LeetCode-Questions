//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String str = read.readLine();
            Solution ob = new Solution();

            System.out.println(ob.buildLowestNumber(str,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String buildLowestNumber(String str, int k) {
        // code here
        Stack<Character> stk = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(var ch : str.toCharArray()){
            while(stk.size()>0 && stk.peek()>ch && k-- >0){
                stk.pop();
            }
            stk.push(ch);
        }
        while(stk.size()>0 && k-->0)stk.pop();
        while(stk.size()>0)ans.append(stk.pop());
        int idx=ans.length()-1;
        
        while(ans.length()>0 && ans.charAt(ans.length()-1)=='0')ans.deleteCharAt(ans.length()-1);
        ans.reverse();
        return ans.length()==0?"0":ans.toString();
    }
}