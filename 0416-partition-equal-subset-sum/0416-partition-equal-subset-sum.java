class Solution {
    //pick not pick makes sense
    //at every step think can array exist?
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum%2!=0)return false;
        int target = sum/2;
        boolean[] dp =new boolean[target + 1];
        dp[0] = true;
        for(int num : nums){
            for(int val = target; val >=num ; val--){
                dp[val] |= dp[val - num];
            }
        }
        return dp[target];
    }
}