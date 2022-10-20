//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.getSum(x, y, z));
        }
    }
}
// } Driver Code Ends


// User Function template for JAVA

class Solution {
    
    public int getSum(int X, int Y, int Z) {
        // Your code goes here
        long[][][] dp=new long[X+1][Y+1][Z+1];
        long[][][] nums=new long[X+1][Y+1][Z+1];
        nums[0][0][0]=1;
        long ans=0;
        for(int i=0;i<=X;++i){
            for(int j=0;j<=Y;++j){
                for(int k=0;k<=Z;++k){
                    if(i>0){
                        dp[i][j][k]+=(dp[i-1][j][k]*10+ 4*nums[i-1][j][k])%mod;
                        nums[i][j][k]+=nums[i-1][j][k]%mod;
                    }
                    
                    if(j>0){
                        dp[i][j][k]+=(dp[i][j-1][k]*10+ 5*nums[i][j-1][k])%mod;
                        nums[i][j][k]+=nums[i][j-1][k]%mod;
                    }
                    
                    if(k>0){
                        dp[i][j][k]+=(dp[i][j][k-1]*10+ 6*nums[i][j][k-1])%mod;
                        nums[i][j][k]+=nums[i][j][k-1]%mod;
                    }
                    
                    ans+=dp[i][j][k]%mod;
                    ans%=mod;
                }
            }
        }
        return (int)ans%mod;
    }
    int mod=(int)(1e9+7);
}