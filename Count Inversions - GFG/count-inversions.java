//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long count;
    static long inversionCount(long arr[], long N)
    {
        // Priyansh Ragit is the best
        count=0;
        mergeSort(0,N-1,arr);
        return count;
    }
    static long[] mergeSort(long lo,long hi,long[] a){
        if(lo==hi)return new long[]{a[(int)lo]};
        
        long mid=lo+(hi-lo)/2;
        long[] left=mergeSort(lo,mid,a);
        long[] right=mergeSort(mid+1,hi,a);
        
        return merge(left,right);
    }
    static long[] merge(long[] left,long[] right){
        long[] res=new long[left.length+right.length];
        
        int i=0,j=0;
        int idx=0;
        while(i<left.length && j<right.length){
            if(left[i]<=right[j]){
                res[idx++]=left[i++];
            }else{
                count+=(left.length-i);//if curr element is greater than right ..this means all next element are also greater
                res[idx++]=right[j++];
            }
        }
        
        while(i<left.length){
            res[idx++]=left[i++];
        }
        while(j<right.length){
            res[idx++]=right[j++];
        }
        return res;
    }
}