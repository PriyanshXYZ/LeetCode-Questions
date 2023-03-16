//{ Driver Code Starts
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
            String[] inp=read.readLine().split(" ");
            int S=Integer.parseInt(inp[0]);
            int D=Integer.parseInt(inp[1]);

            Solution ob = new Solution();
            System.out.println(ob.secondSmallest(S,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String secondSmallest(int S, int D){
        // code here
        int[] nums = new int[D];
        
        //try to generate minimum possible number.. which is possible by maximizing LSB
        for(int i=D-1;i>0;i--){
            int dig = Math.min(S-1,9);
            
            nums[i] = dig;
            S -= dig;
        }
        if(S>9)return "-1"; // impossible to make sum in given no of digits
        else{
            nums[0] = S;
        }
        
        //idea for second smallest number is to change LSB such that we interchange the digits
        for(int i=D-1;i>0;i--){
            if(nums[i]!=0 && nums[i-1]!=9){
                nums[i] -= 1;
                nums[i - 1] += 1;
                StringBuilder ans = new StringBuilder();
                for(int val : nums){
                    ans.append(val);
                }
                return ans.toString();
            }
        }
        return "-1";
    }
}