// { Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int n = Integer.parseInt(input[0]); 
            int d = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            int[] ans = ob.numAndDen(n,d);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int gcd(int a,int b){
        if(a==0)return b;
        if(a==1)return a;
        return gcd(b%a,a);
    }
    public int[] numAndDen(int n, int d)
    {
        // code here
        
        double frac=0;
        double reqFrac=(double)n/d;
        int[] ans=new int[2];
        for(int i=n+1;i<=10000;i++){
            
            int j=(i*d)/n+1;
            // System.out.println(i +" "+j);
            if(j>10000)break;
            double v=(double)i/j;
            if(v<reqFrac && v>frac){
                frac=v;
                ans[0]=i;
                ans[1]=j;
            }
        }
        
        
        return ans;
    }
}