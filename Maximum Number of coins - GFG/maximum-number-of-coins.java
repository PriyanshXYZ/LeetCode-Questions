//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> arr = new ArrayList<>(N);
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < N; i++) {
				arr.add(Integer.parseInt(str[i]));
			}
			Solution obj = new Solution();
			System.out.println(obj.maxCoins(N, arr));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    Integer[][] dp;
    int maxCoins(int N, ArrayList<Integer> arr) {
		//Write your code here
		arr.add(0,1);
		arr.add(1);
// 		System.out.println(arr);
		dp = new Integer[N+2][N+2];
	    
	    return memo(arr, 0, N+1);
	}
	int memo(ArrayList<Integer> a, int l, int r){
	    //base case
	    if(l>=r)return 0;
	    
	    //memoize
	    if(dp[l][r]!=null)return dp[l][r];
	    
	    
	    int ans = 0;
	    for(int m = l + 1; m < r; m++){
	       int curr = a.get(l) * a.get(m) * a.get(r) + memo(a, m, r) + memo(a, l, m);
	       ans = Math.max(ans, curr );
	    }
	    return dp[l][r] = ans;
	}
}