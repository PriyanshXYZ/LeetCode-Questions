//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int[] dp=new int[n+1];
        // return recursion(price,n);
        Arrays.fill(dp,-1);
        // return memo(price,n,dp);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int ans=0;
            for(int j=1;j<=i;j++){
                ans=Math.max(ans,price[j-1]+dp[i-j]);
            }
            dp[i]=ans;
        }
        return dp[n];
    }
    public int recursion(int[] price,int n){
        if(n==0)return 0;
        
        int ans=0;
        for(int i=1;i<=n;i++){
            ans=Math.max(ans,price[i-1]+recursion(price,n-i));
        }
        return ans;
    }
    public int memo(int[] price,int n ,int[] dp){
        if(n==0)return 0;
        if(dp[n]!=-1)return dp[n];
        int ans=0;
        for(int i=1;i<=n;i++){
            ans=Math.max(ans,price[i-1]+memo(price,n-i,dp));
        }
        return dp[n]=ans;
    }
}