class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int start=-1;
        int curr=-1;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] >=left && nums[i] <=right){
                curr=i;
            }else if(nums[i] > right){
                curr=start=i;
            }
            
            count+=curr-start;
            
        }
        return count;
    }
}