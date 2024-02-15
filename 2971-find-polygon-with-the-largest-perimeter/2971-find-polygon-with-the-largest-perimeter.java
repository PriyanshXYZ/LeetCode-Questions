class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = -1;
        long currSum = nums[0] + nums[1];
        for(int i=2;i<nums.length;i++){
            if(currSum > nums[i]){
                sum = nums[i] + currSum;
            }
            currSum += nums[i];
        }
        return sum;
    }
}