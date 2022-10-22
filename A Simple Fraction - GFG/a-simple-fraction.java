//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int numerator = Integer.parseInt(S[0]);
            int denominator = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            String ans = ob.fractionToDecimal(numerator, denominator);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String  fractionToDecimal(int num, int dem)
    {
        // code here
        int quo=num/dem;
        int rem=num%dem;
        
        if(rem==0)return quo+"";
        
        String ans=quo+".";
        String frac="";
        
        HashMap<Integer,Integer> map=new HashMap<>();
        int idx=0;
        
        while(rem!=0 && map.containsKey(rem)==false){
            map.put(rem,idx);
            idx++;
            
            rem*=10;
            quo=rem/dem;
            rem=rem%dem;
            frac+=quo+"";
        }
        // System.out.println(map);
        if(rem==0){
            ans+=frac;
        }else{
            idx=map.get(rem);
            ans+=frac.substring(0,idx)+"("+frac.substring(idx)+")";
        }
        return ans;
        
    }
}