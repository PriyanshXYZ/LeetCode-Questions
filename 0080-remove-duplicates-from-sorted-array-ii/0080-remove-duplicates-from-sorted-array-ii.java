class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int k = 1;
        for(int i = 2; i < n; i++) {
            if(nums[i] != nums[k]){
                nums[++k] = nums[i];
            }else if(nums[i] == nums[k] && nums[k] != nums[k-1]){
                nums[++k] = nums[i];
            }
        }
        return k + 1;
    }
}