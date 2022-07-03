// { Driver Code Starts
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
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        HashMap<Integer,Integer> origPos=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            origPos.put(nums[i],i);
        }
        
        Arrays.sort(nums);
        int ans=0;
        
        boolean[] vis=new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            if(origPos.get(nums[i])==i || vis[i]==true){
                continue;
            }
            vis[i]=true;
            
            int j=origPos.get(nums[i]);
            int cycleSize=1;
            
            while(j!=i){
                vis[j]=true;
                cycleSize++;
                j=origPos.get(nums[j]);
            }
            ans+=cycleSize-1;
        }
        return ans;
    }
}

// class Solution1
// {
//     int[] parent;
//     int[] r
//     public int minSwaps(int nums[])
//     {
          
//     }
// }