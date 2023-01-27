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
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.CountWays(str);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int mod = (int)(1e9+7);
    public int CountWays(String str)
    {
        // code here
        int n = str.length();
        if(str.charAt(0)=='0' )return 0;
        
        Integer[] dp = new Integer[n];
        
        return memo(0,str,dp);
    }
    public int memo(int idx, String s, Integer[] dp){
        if(idx>=s.length())return 1;
        
        if(dp[idx] != null)return dp[idx];
        
        int cnt = 0;
        int ch1 = s.charAt(idx) - '0';
        if(ch1>0 && ch1<10){
            cnt = (cnt % mod + memo(idx + 1, s, dp) % mod) % mod;
        }
        
        if(idx+1<s.length()){
            int num = (s.charAt(idx)-'0') * 10 + (s.charAt(idx+1)-'0');
            if(num>9 && num<27){
                cnt = (cnt % mod + memo(idx + 2, s, dp) % mod) % mod;
            }
        }
        return dp[idx]=cnt;
    }
}