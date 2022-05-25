// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int test = Integer.parseInt(br.readLine());
    	while(test-- > 0) {
    		String [] str = br.readLine().trim().split(" ");
    		int N = Integer.parseInt(str[0]);
    		int K = Integer.parseInt(str[1]);
    		int M = Integer.parseInt(str[2]);
    		int [] A = new int[N];
    		str = br.readLine().trim().split(" ");
    		for(int i = 0; i < N; i++)
    			A[i] = Integer.parseInt(str[i]);
    		Solution obj = new Solution();
    		boolean ans = obj.partitionArray(N, K, M, A);
    		if(ans){
                System.out.println("YES");
            }
            else{
            	System.out.println("NO");
            }
    	}
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
	boolean partitionArray(int n, int k, int m, int [] a){
        // code here
        Arrays.sort(a);
        return recursion(0,k,m,a);
    }
    boolean recursion(int start,int k,int diff,int[] a){
        int n=a.length;
        if(start==n){
            return true;
        }
       
        for(int i=start+k-1;i<n;i++){
            if(a[i]-a[start]>diff){
                return false;
            }
            if(recursion(i+1,k,diff,a)){
                return true;
            }
        }
        return false;
        
    }
}