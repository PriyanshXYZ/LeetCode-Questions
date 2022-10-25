//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
class GFG {
    public static void main(String[] args)
    {   Scanner sc = new Scanner(System.in);
    	int t=sc.nextInt();
    	while(t-->0)
    	{
    		String str1=sc.next();
    		String str2=sc.next();
    		int k=sc.nextInt();
            Solution ob = new Solution();
    		if (ob.areKAnagrams(str1, str2, k) == true)
    			System.out.println("1");
    		else
    			System.out.println("0");
    	}
    }
}
// } Driver Code Ends


//User function template for JAVA

class Solution {
    boolean areKAnagrams(String s1, String s2, int k) {
        // code here
        if(s1.length()!=s2.length())return false;
        
        int[] map1=new int[26];
        
        for(char ch:s1.toCharArray()){
            map1[ch-'a']++;
        }
        
        int[] map2=new int[26];
        
        for(char ch:s2.toCharArray()){
            map2[ch-'a']++;
        }
        
        int count=0;
        for(int i=0;i<26;i++){
            if(map1[i]>map2[i]){
                count+=Math.abs(map1[i]-map2[i]);
            }
        }
        return count<=k;
    }
}