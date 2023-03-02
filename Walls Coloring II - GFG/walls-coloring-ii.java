//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int [][] costs = new int[n][k];
			for(int i = 0; i < n; i++) {
				str = br.readLine().trim().split(" ");
				for(int j = 0; j < k; j++) {
					costs[i][j] = Integer.parseInt(str[j]);
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.minCost(costs));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minCost(int [][] costs) {
		//Write your code here
		int n=costs.length;
        if(n==0)return -1;
        int k=costs[0].length;
        
        long[][] dp=new long[n][k];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++){

            long min=Integer.MAX_VALUE;
            long secMin=Integer.MAX_VALUE;
            boolean flag=false;
            for(int j=0;j<k;j++){
                if(i==0){
                    dp[i][j]=costs[i][j];
                    flag=true;
                    continue;
                }
                
                if(dp[i-1][j]<min){
                    secMin=min;
                    min=dp[i-1][j];
                }else if(dp[i-1][j]<secMin){
                    secMin=dp[i-1][j];
                }
            }
            if(!flag){
                for(int j=0;j<k;j++){
                    if(dp[i-1][j]==min){
                        dp[i][j]=secMin;
                    }else{
                        dp[i][j]=min;
                    }
                    dp[i][j]+=costs[i][j];
                }
            }        
        }

        long ans=Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            ans=Math.min(dp[n-1][i],ans);
        }
        return ans>=Integer.MAX_VALUE?-1:(int)(ans);
	}
}