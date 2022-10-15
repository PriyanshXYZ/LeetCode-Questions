//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            
            Solution ob = new Solution();
            if(ob.sameFreq(a)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    boolean sameFreq(String s) {
        //code here
        HashMap<Character,Integer> map=new HashMap<>();
        // int freq1=0;
        // int freq2=0;
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
            // if(freq1<map.get(ch)){
            //     freq2=freq1;
            //     freq1=map.get(ch);
            // }else if(freq2<map.get(ch)){
            //     freq2=map.get(ch);
            // }
        }
        
        List<Integer> set=new ArrayList<>();
        for(int val:map.values()){
            if(!set.contains(val))
                set.add(val);
        }
        // System.out.println(map);
        // System.out.println(set);
        
        if(set.size()==1)return true;
        else if(set.size()!=2)return false;
        
        int val1=set.get(0);
        int val2=set.get(1);
        
        // System.out.println(val1+" "+val2);
        if(val1==1 || val2==1)return true;
        if(Math.abs(val1-val2)>1)return false;
        return true;
        
    }
}