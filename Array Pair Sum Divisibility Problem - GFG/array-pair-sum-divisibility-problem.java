//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(S2[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.canPair(nums, k);
            if (ans)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean canPair(int[] nums, int k) {
        // Code here
        HashMap<Integer,Integer> map = new HashMap();
        for(int val : nums){
            int num = val % k;
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int lkey=1;
        int hkey=k-1;
        while(lkey<hkey){
            int freql = map.getOrDefault(lkey, 0);
            int freqh = map.getOrDefault(hkey, 0);
            if(freql != freqh)return false;
            lkey++;
            hkey--;
        }
        int zero=map.getOrDefault(0,0);
        if(zero % 2 != 0)return false;
        if(k%2 != 0){
            int kby2=map.getOrDefault(k/2,0);
            if(kby2 % 2 != 0)return false;
        }
        return true;
    }
}