class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo=0;
        int hi=nums.length;
        
        while(lo<hi){
            int mid=(lo+hi)/2;
            
            if(nums[mid]>target){
                hi=mid;
            }else if(nums[mid]<target){
                lo=mid+1;
            }else{
                return mid;
            }
        }
        return lo;
    }
}