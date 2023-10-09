class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length<1)return new int[]{-1,-1};
        int lo = 0;
        int hi = nums.length-1;
        int left = 0, right = 0;
        
        while(lo<hi){
            int mid = (lo + hi) / 2;
            
            if(nums[mid]<target){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        if(nums[lo] != target)return new int[]{-1,-1};
        left = lo;
        
        hi = nums.length-1;
        while(lo<hi){
            int mid = (lo + hi) / 2 + 1;
            
            
            
            if(nums[mid]<=target){
                lo = mid;
            }else{
                hi = mid - 1;
            }
        }
        right = lo;
        return new int[]{left,right};
    }
}