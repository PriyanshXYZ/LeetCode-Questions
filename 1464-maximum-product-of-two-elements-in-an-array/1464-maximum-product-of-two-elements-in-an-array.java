class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        return (nums[n]-1)*(nums[n-1]-1);
    }
}