class Solution {
    public int minimizeSum(int[] nums) {
        if(nums.length==3)return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int ans = Math.min(Math.min(nums[n-1] - nums[2], nums[n-3] - nums[0]), nums[n-2] - nums[1]);
        return ans;
    }
}