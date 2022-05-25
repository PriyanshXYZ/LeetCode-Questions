// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            Long A = Long.parseLong(S[0]);
            Long B = Long.parseLong(S[1]);

            Solution ob = new Solution();
            Long[] ptr = ob.lcmAndGcd(A,B);
            
            System.out.print(ptr[0]);
            System.out.print(" ");
            System.out.println(ptr[1]);
        }
    }
}// } Driver Code Ends


class Solution {
    static Long[] lcmAndGcd(Long a , Long b) {
        // code here
        Long[] ans=new Long[2];
        ans[1]=gcd(a,b);
        ans[0]=lcm(ans[1],b,a);
        return ans;
    }
    static Long gcd(Long a,Long b){
        if(a==0)return b;
        if(a==1)return a;
        return gcd(b%a,a);
    }
    static Long lcm(Long gcd,Long a,Long b){
        return (Long)(a*b/gcd);
    }
};