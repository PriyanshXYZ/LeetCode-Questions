// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findSubString( String s) {
        // Your code goes here
        HashSet<Character> distinct = new HashSet<>();
		for(char ch  : s.toCharArray()){
			distinct.add(ch);
		}
		HashMap<Character,Integer> idxMap=new HashMap<>();
        
        int si=0,ei=0,minLen=s.length()+1;//start idx,end idx,maxLen possible
		int strtIdx=-1;
        for(;ei<s.length();ei++){
            
            idxMap.put(s.charAt(ei),idxMap.getOrDefault(s.charAt(ei),0)+1);
			
			if(idxMap.size()==distinct.size()){
				while(idxMap.get(s.charAt(si))>1){
					idxMap.put(s.charAt(si),idxMap.get(s.charAt(si))-1);
					si++;
				}
				if(minLen > ei-si+1 ){
					minLen=ei-si+1;	
					strtIdx = si;
				}
			}
        }
		
        return minLen;
    }
}