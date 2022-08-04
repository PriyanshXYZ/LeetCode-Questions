class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1)return nums[0];
        int lo=0,hi=nums.length-1;
        
        while(lo<hi){
            int mid=lo+(hi-lo)/2;
            if(nums[hi]>nums[mid]){
                hi=mid;
            }else {
                lo=mid+1;
            }
        }
        return nums[lo];
    }
}