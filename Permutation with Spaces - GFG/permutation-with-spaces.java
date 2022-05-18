// { Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine().trim();
            Solution ob = new Solution();
            ArrayList<String> ans = new ArrayList<String>();
            ans = ob.permutation(S);
            
            for(int i=0;i<ans.size();i++){
                System.out.print("("+ans.get(i)+")");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution{
    
    void recursion(int idx,String s,String op,int n,ArrayList<String> list){
        if(idx==n){
            list.add(op);
            return;
        }
        char ch=s.charAt(idx);
        if(idx!=0)recursion(idx+1,s,op+" "+ch,n,list);
        recursion(idx+1,s,op+ch,n,list);
    }
    ArrayList<String> permutation(String S){
        // Code Here
        ArrayList<String> list=new ArrayList<String>();
        recursion(0,S,"",S.length(),list);
        return list;
    }
    
}