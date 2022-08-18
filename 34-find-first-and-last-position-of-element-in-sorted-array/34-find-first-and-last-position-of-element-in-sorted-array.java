class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0)return new int[]{-1,-1};
        int lo=0;
        int hi=nums.length-1;
        
        while(lo<hi){
            int mid=lo+(hi-lo)/2;
            
            if(nums[mid]<target){
                lo=mid+1;
            }else{
                hi=mid;
            }
        }
        if(nums[lo]!=target){
            return new int[]{-1,-1};
        }
        int left=lo;
        int right=0;
        hi=nums.length-1;
        while(lo<hi){
            int mid=lo+(hi-lo)/2+1;
            
            if(nums[mid]>target){
                hi=mid-1;
            }else{
                lo=mid;
            }
        }
        right=lo;
        return new int[]{left,right};
    }
}