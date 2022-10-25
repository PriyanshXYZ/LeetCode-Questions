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
        Map<Character,Integer> map=new HashMap<>();
        for(char ch:s1.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        
        for(char ch:s2.toCharArray()){
            if(map.containsKey(ch) ){
                map.put(ch,map.get(ch)-1);    
            }
            
        }
        // System.out.println(map);
        int count=0;
        
        for(char key:map.keySet()){
            if(map.get(key)>0){
                count+=map.get(key);
            }
        }
        // System.out.println(count);
        return count<=k;
    }
}