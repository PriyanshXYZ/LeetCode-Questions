//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
    {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0;i<t;i++){
		    String s = in.next();
		    if (new Sol().isPossible (s) == 1)
		        System.out.println ("Yes");
		    else
		        System.out.println ("No");
		}
	}
}

// Contributed By: Pranay Bansal


// } Driver Code Ends


class Sol
{
    int isPossible (String S)
    {
        // your code here
        int[] freq=new int[26];
        
        for(char ch:S.toCharArray()){
            freq[ch-'a']++;
        }
        
        int count=0;
        for(int val:freq){
            if(val%2!=0){
                count++;
            }
        }
        if(count<=1)
            return 1;
        return 0;
    }
}