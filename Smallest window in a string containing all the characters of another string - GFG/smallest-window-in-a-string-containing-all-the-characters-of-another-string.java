//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String a, String b)
    {
        // Your code here
        if(b.length()>a.length())return "-1";
		
		int[] freqB = new int[26];
		int[] freqA = new int[26];
		
		for(char ch : b.toCharArray()){
			freqB[ch-'a']++;
		}
		
		int minLen = Integer.MAX_VALUE;
		int strtIdx = -1;
		int cnt=0;
		for(int ei=0,si=0;ei<a.length();ei++){
			int ch1 =a.charAt(ei)-'a';
			freqA[ch1]++;
			if(freqA[ch1]<=freqB[ch1]){
				cnt++;
			}
			if(cnt==b.length()){

				while(freqA[a.charAt(si)-'a'] > freqB[a.charAt(si)-'a'] || freqB[a.charAt(si)-'a']==0){
					
					if(freqA[a.charAt(si)-'a'] > freqB[a.charAt(si)-'a']){
						freqA[a.charAt(si)-'a']--;
					}
					si++;
				}
				if(minLen > ei - si + 1){
					minLen = ei - si + 1;
					strtIdx = si;
				}
			}
		}
		if(strtIdx==-1)return "-1";
		else return a.substring(strtIdx,strtIdx+minLen);
    }
}