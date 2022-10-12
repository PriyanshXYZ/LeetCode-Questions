class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int max=0;
        for(int i=2;i<nums.length;i++){
            if(nums[i-2]+nums[i-1]>nums[i]){
                max=Math.max(max,nums[i-1]+nums[i-2]+nums[i]);
            }
        }
        return max;
    }
}