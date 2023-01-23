//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.removePair(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String removePair(String s) {
        // code here
        Stack<Character> stk = new Stack<>();
        
        for(char ch  : s.toCharArray()){
            if(stk.isEmpty() || stk.peek()!=ch){
                stk.push(ch);
            }else{
                stk.pop();
            }
        }
        String ans = "";
        while(stk.size()>0){
            ans=stk.pop() + ans;
        }
        return ans==""?"-1":ans;
    }
}
        
