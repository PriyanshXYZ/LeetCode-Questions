//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] input = new String[2]; 
            input = read.readLine().split(" "); 
            int R = Integer.parseInt(input[0]); 
            int C = Integer.parseInt(input[1]); 
            String s1[] = read.readLine().trim().split("\\s+");
            int a[][] = new int[R][C];
            for(int i = 0;i < R*C;i++)
                a[i/C][i%C] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int[] ans = ob.reverseSpiral(R,C,a);
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
    public int[] reverseSpiral(int R, int C, int[][] a)
    {
        // code here
        int r1=0,c1=0,r2=R-1,c2=C-1;
        int[] res=new int[R*C];
        int idx=0;
        while(idx<R*C){
            //l2r
            for(int j=c1;j<=c2 && idx<R*C;j++){
                res[idx++]=a[r1][j];
            }
            
            r1++;
            //t2b
            for(int i=r1;i<=r2 &&  idx<R*C;i++){
                res[idx++]=a[i][c2];
            }
            c2--;
            
            //r2l
            for(int j=c2;j>=c1 && idx<R*C;j--){
                res[idx++]=a[r2][j];
            }
            r2--;
            
            for(int i=r2;i>=r1 && idx<R*C;i--){
                res[idx++]=a[i][c1];
            }
            c1++;
        }
        int i=0,j=R*C-1;
        while(i<j){
            int temp=res[i];
            res[i]=res[j];
            res[j]=temp;
            i++;
            j--;
        }
        return res;
    }
}