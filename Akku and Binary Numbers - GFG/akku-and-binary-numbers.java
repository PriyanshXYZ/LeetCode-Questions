//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        Solution ob = new Solution();
        ob.precompute();
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            long L = Long.parseLong(input_line[0]);
            long R = Long.parseLong(input_line[1]);
            long ans = ob.solve(L, R);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java


class Solution{

    void precompute(){
        // Code Here
    }

    long solve(long L, long R){
        // Code here
        long ans = 0;
        
        for(int i = 0;i < 64; i++){
            for(int j = i + 1;j < 64; j++){
                for(int k = j + 1; k < 64; k++){
                    long temp =(long) Math.pow(2, i) + (long)Math.pow(2, j) + (long)Math.pow(2, k);
                    
                    if(temp>=L && temp<=R)ans++;
                }
            }
        }
        return ans;
    }
    
}
