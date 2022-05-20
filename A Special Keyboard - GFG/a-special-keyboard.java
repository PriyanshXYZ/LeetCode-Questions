// { Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String S1 = read.readLine();
            String S2 = read.readLine();

            Solution ob = new Solution();

            System.out.println(ob.findTime(S1,S2));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findTime(String S1 , String S2) {
        
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        //filling keyboard values with idx in hashmap
        for(int i=0;i<S1.length();i++){
            char ch=S1.charAt(i);
            map.put(ch,i);
        }

        int time=0;
        int prev=0;
        
        for(int i=0;i<S2.length();i++){
            char ch=S2.charAt(i);
            int curr=map.get(ch);
            // System.out.println(curr);
            time+=Math.abs(curr-prev);
            
            prev=curr;
        }
        return time;
    }
};