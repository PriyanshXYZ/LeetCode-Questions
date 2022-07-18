class Solution {
    public int maxChunksToSorted(int[] arr) {
        //store a right to left min array which store corresponding lowest from  idx to n
        int n=arr.length;
        int[] minFromRight=new int[n];
        
        int min=Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            min=Math.min(min,arr[i]);
            minFromRight[i]=min;
        }
        
        int chunks=1;
        int max=arr[0];
        for(int i=0;i<n-1;i++){
            
            max=Math.max(arr[i],max);
            if(max<=minFromRight[i+1]){
                chunks++;
            }
        }
        
        return chunks;
    }
}