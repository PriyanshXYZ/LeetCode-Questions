//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		     
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    Arrays.sort(arr);
		    Complete obj = new Complete();
		    int ans = obj.maximizeSum(arr, sizeOfArray);
		    System.out.println(ans);
		}
	}
}




// } Driver Code Ends


//User function Template for Java



class Complete{
    
   
    // Function for finding maximum and value pair
    public static int maximizeSum (int arr[], int n) {
        //Complete the function
        TreeMap<Integer,Integer> map=new TreeMap<>();
        
        for(int val:arr){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        int max=arr[n-1];
        int sum=0;
        while(map.size()>0){
            if(map.containsKey(max)){
                sum+=max;
                map.put(max,map.get(max)-1);
                if(map.get(max)==0){
                    map.remove(max);
                }
                if(map.containsKey(max-1)){
                    map.put(max-1,map.get(max-1)-1);
                    if(map.get(max-1)==0){
                        map.remove(max-1);
                    }
                }
            }
            if(map.size()!=0)
                max=map.lastKey();
        }
        return sum;
    }
    
    
}


