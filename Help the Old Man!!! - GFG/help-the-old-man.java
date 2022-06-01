// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int n = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.shiftPile(N, n);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<ArrayList<Integer>> ans;
    static List<Integer> shiftPile(int N, int n){
        // code here
        ans=new ArrayList<ArrayList<Integer>>();
        recursion(1,3,2,N,n);
        return ans.get(n-1);
    }
    static void recursion(int src,int dest,int aux,int plates,int move){
        if(plates==0){
            return;
        }
                
        ArrayList<Integer> list=new ArrayList<Integer>();
        recursion(src,aux,dest,plates-1,move-1);
        list.add(src);
        list.add(dest);
        ans.add(list);
        recursion(aux,dest,src,plates-1,move-1);
    }
}