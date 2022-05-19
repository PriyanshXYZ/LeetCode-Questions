// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
                {
                    String arr[] = br.readLine().split(" ");
                    String A = arr[0];
                    String B = arr[1];
                    Solution obj = new Solution();
                    System.out.println(obj.transform (A, B));
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    int transform (String A, String B)
    {
        // code here
        int i=A.length()-1;
        int j=B.length()-1;
        int ans=0;
        
        if(A.length()!=B.length())return -1;
        HashMap<Character,Integer> mapA=new HashMap<Character,Integer>();
        HashMap<Character,Integer> mapB=new HashMap<Character,Integer>();
        
        
        //storing in hasmap
        for(int k=0;k<=i;k++){
            char ch1=A.charAt(k);
            if(mapA.containsKey(ch1)){
                mapA.put(ch1,mapA.get(ch1)+1);
            }else{
                mapA.put(ch1,1);
            }
            char ch2=B.charAt(k);
            if(mapB.containsKey(ch2)){
                mapB.put(ch2,mapB.get(ch2)+1);
            }else{
                mapB.put(ch2,1);
            }
        }
        
       
        
        if(mapA.equals(mapB)==false)return -1;
        while(i>=0 && j>=0){
            if(A.charAt(i)==B.charAt(j)){
                i--;
                j--;
            }else{
                i--;
                ans++;
            }
        }
        return ans;
    }
}