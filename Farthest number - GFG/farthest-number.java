// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        PrintWriter out = new PrintWriter(System.out);
        
        int t = Integer.parseInt(br.readLine()); 

        while(t > 0){
        	int N = Integer.parseInt(br.readLine()); 
        	int[] Arr = new int[N];
        	String line = br.readLine(); 
            String[] strs = line.trim().split("\\s+"); 
        	for(int i=0; i<N; i++)
        	{
        		Arr[i] = Integer.parseInt(strs[i]); 
        	}
        	

            Solution ob = new Solution();
			int[] ans = ob.farNumber(N,Arr);
  
            for(int i=0; i<ans.length; i++)
                out.print(ans[i] + " ");
            out.println();

            t--;
        }
        out.flush();
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static int[] farNumber(int n, int[] a)
	{    
	   // HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
	   // for(int i=0;i<n;i++){
	   //     map.put(i,-1);
	   // }
	    int[] res=new int[n];
	    Arrays.fill(res,-1);
	    for(int i=0;i<n;i++){
	        for(int j=n-1;j>=i+1;j--){
	            if(a[i]>a[j]){
	               // map.put(i,j);
	                res[i]=j;
	                break;
	            }
	        }
	    }
	   // System.out.println(map);
	    
	   // int count=0;
	   // for(int item:map.values()){
	   //     res[count++]=item;
	   // }
	    return res;
        
	}
} 