class Solution {
    public int[] searchRange(int[] nums, int target) {
        int strt=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                strt=i;
                break;
            }
        }
        int end=-1;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]==target){
                end=i;
                break;
            }
        }
        return new int[]{strt,end};
    }
}