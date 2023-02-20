//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    static final int O=0;
    static final int A=1;
    static final int B=2;
    static final int C=3;
    static final int mod = (int)(1e9+7);
    static Long[][] dp;
	public static int countPaths(int N){
		//code here
		dp = new Long[N+1][4];
// 		return (int)(memo(O,N)%mod);
        // return tabulation(N);
        long cntO=1l;
        long cntA=0l;
        long cntB=0l;
        long cntC=0l;
        
        for(int i=1;i<=N;i++){
            long ccntO = cntA % mod + cntB % mod + cntC % mod;
            long ccntA = cntO % mod + cntB % mod + cntC % mod;
            long ccntB = cntA % mod + cntO % mod +cntC % mod;
            long ccntC = cntA % mod + cntB % mod + cntO % mod;
            ccntO%=mod;
            ccntA%=mod;
            ccntB%=mod;
            ccntC%=mod;
            
            cntO=ccntO;
            cntA=ccntA;
            cntB=ccntB;
            cntC=ccntC;
        }
        return (int)(cntO%mod);
	}
	public static int tabulation(int N){
	    dp[0][0]=1l;
        dp[0][1]=0l;
        dp[0][2]=0l;
        dp[0][3]=0l;
        
        for(int i=1;i<=N;i++){
            dp[i][0] = dp[i-1][1] % mod + dp[i-1][2] % mod + dp[i-1][3] % mod;
            dp[i][1] = dp[i-1][0] % mod + dp[i-1][2] % mod + dp[i-1][3] % mod;
            dp[i][2] = dp[i-1][1] % mod + dp[i-1][0] % mod + dp[i-1][3] % mod;
            dp[i][3] = dp[i-1][1] % mod + dp[i-1][2] % mod + dp[i-1][0] % mod;
            dp[i][0]%=mod;
            dp[i][1]%=mod;
            dp[i][2]%=mod;
            dp[i][3]%=mod;
        }
        return (int)(dp[N][0]%mod);
	}
	
	public static long memo(int vtc, int n){
	    if(n==0){
	        if(vtc==O)return 1;
	        return 0;
	    }
	    
	   
	    if(dp[n][vtc]!=null)return dp[n][vtc];
	    
	    if(vtc == O){
	        dp[n][vtc] = memo(A, n - 1) % mod + memo(B, n - 1) %mod + memo(C, n - 1) % mod;
	    }else if(vtc==A){
	        dp[n][vtc] = memo(O, n - 1) % mod + memo(B, n - 1) %mod + memo(C, n - 1) % mod;
	    }else if(vtc==B){
	        dp[n][vtc] = memo(A, n - 1) % mod + memo(O, n - 1) %mod + memo(C, n - 1) % mod;
	    }else{
	        dp[n][vtc] = memo(A, n - 1) % mod + memo(B, n - 1) %mod + memo(O, n - 1) % mod;
	    }
	    dp[n][vtc]%=mod;
	    return dp[n][vtc];
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countPaths(N));
        }
    }
}

// } Driver Code Ends