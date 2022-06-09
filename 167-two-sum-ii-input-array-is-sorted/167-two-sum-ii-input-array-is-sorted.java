class Solution {
    // public int[] twoSum(int[] a, int target) {
    //     // brute force approach
    //     for(int i=0;i<a.length;i++){
    //         for(int j=i+1;j<a.length;j++){
    //             if(a[i]+a[j]==target){
    //                 int[] ans={i+1,j+1};
    //                 return ans;
    //             }
    //         }
    //     }
    //     return new int[2];
    // }
    
    
    public int[] twoSum(int[] a, int target){
        int start=0,end=a.length-1;
        while(start<end){
            if(a[start]+a[end]<target)start++;
            else if(a[start]+a[end]>target)end--;
            else{
                int[] ans={start+1,end+1};
                return ans;
            }
        }
        return new int[2];
    }
    
}