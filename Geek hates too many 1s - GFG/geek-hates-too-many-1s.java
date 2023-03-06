//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.noConseBits(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int noConseBits(int n) {
        // code here
        int ans = 0;
        int cnt =0;
        for(int i=31;i>=0;i--){
            // if(cnt==3){
            //     cnt = 0;
            //     continue;
            // }
            if((n & 1<<i) > 0 && cnt<=1){
                ans |= 1<<i;
                cnt++;
            }else{
                cnt=0;
            }
        }
        return ans;
    }
}
        
