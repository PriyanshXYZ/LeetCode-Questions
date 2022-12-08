//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int q = sc.nextInt();
            ArrayList<Long> query = new ArrayList<>();
            for(int i=0;i<q;i++){
                query.add(sc.nextLong());
            }
            Solution ob = new Solution();
                
            ArrayList<Integer> ans = ob.threeDivisors(query,q);
            for(int cnt : ans) {
                System.out.println(cnt);
            }
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q){
        // code here
        //using prime sievew
        boolean[] primes=new boolean[(int)1e6+5];
        Arrays.fill(primes,true);
        primes[0]=primes[1]=false;
        for(int i=2;i*i<primes.length;i++){
            if(primes[i]){
                for(int j=i*2;j<primes.length;j+=i){
                    primes[j]=false;
                }
            }
        }
        
        int[] dp=new int[(int)1e6+5];
        for(int i=2;i<dp.length;i++){
            dp[i]=dp[i-1];
            if(primes[i])dp[i]++;
        }
        ArrayList<Integer> res=new ArrayList();
        for(int i=0;i<query.size();i++){
            int sq=(int)Math.sqrt(query.get(i));
            res.add(dp[sq]);
        }
        return res;
    }
}