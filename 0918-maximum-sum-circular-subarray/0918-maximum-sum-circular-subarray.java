class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max = Integer.MIN_VALUE;
        int currmax = 0;
        int min = Integer.MAX_VALUE;
        int currmin = 0;
        int sum = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            currmax = Math.max(nums[i],currmax+nums[i]);
            currmin = Math.min(nums[i],currmin+nums[i]);
            max = Math.max(max, currmax);
            min = Math.min(min , currmin);
        }
        if(sum==min)return max;
        return Math.max(sum-min,max);
    }
}