//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.goodStones(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public static int goodStones(int n, int[] arr) {
        //find the cycles in the graph ... if there are cycles we need to exclude it
        Integer[] dp = new Integer[n];
        int[] vis = new int[n];
        int ans = 0;
        for(int i=0;i<n;i++){
            if(arr[i]!=0 && possible(i,arr,dp,vis)==1){
                ans++;
            }
        }
        
        return ans;
    }
    public static int possible(int idx, int[] arr, Integer[] dp,int[] vis){
        if(idx<0 || idx>=arr.length)return 1;
        
        if(dp[idx]!=null)return dp[idx];
        if(vis[idx]!=0)return 0;
        
        vis[idx]=1;
        
        dp[idx]=possible(idx+arr[idx],arr,dp,vis);
        return dp[idx];
    }
}
        
