// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    int k = Integer.parseInt(br.readLine().trim());
		    
		    Solution ob= new Solution();
		    System.out.println(ob.countKdivPairs(arr, n, k));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static long countKdivPairs(int arr[], int n, int k)
    {
        //code here
        // long[] hash=new long[k];
        // //storing the freq of remainder obtained from each element
        // for(int i=0;i<n;i++){
        //     hash[arr[i]%k]++;
        // }
        // //case 1:if element is divisible by k
        // //this will give remainder 0 so we add this using adddition of n numbers
        // long sum=hash[0]*(hash[0]-1)/2;
        
        // //case 2:if element is not divisble by k
        // //we go till half of the hash array to avoid duplicacy
        // for(int i=1;i<=k/2 && i!=(k-i);i++){
        
        //     sum+=hash[i]*hash[k-i];
        // }
        
        // //case 3 if k is even so k/2 th idx will lead to ambiguity
        // if(k%2==0)
        //     sum+=hash[k/2]*(hash[k/2]-1)/2;
        
        // return sum;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int val:arr){
            map.put(val%k,map.getOrDefault(val%k,0)+1);
        }
        
        long ans=0;
        int i=1,j=k-1;
        while(i<j){
            int pair1=map.getOrDefault(i,0);
            int pair2=map.getOrDefault(j,0);
            ans+=pair1*pair2;
            i++;
            j--;
        }
        
        //for pairs divisible by k ans will be Nc2
        int div0=map.getOrDefault(0,0);
        ans+=div0*(div0-1)/2;
        
        
        // if k is even then one of the pair of k/2 is skipped above so we add it here which is also nc2
        if(k%2==0){
            div0=map.getOrDefault(k/2,0);
            ans+=div0*(div0-1)/2;
        }
        return ans;
    }
}