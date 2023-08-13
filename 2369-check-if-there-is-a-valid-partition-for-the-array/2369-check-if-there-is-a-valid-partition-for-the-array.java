class Solution {
    Boolean[] dp;
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        dp = new Boolean[n];
        return memo(0,n,nums);
    }
    
    public boolean memo(int i, int n, int[] nums){
        if(i==n)return true;
        
        if(dp[i] != null)return dp[i];
        
        boolean ans = false;
        
        if(i < n - 1 && nums[i] == nums[i + 1]){
            ans |= memo(i + 2, n, nums);
        }
        
        if(i < n - 2 && nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]){
            ans |= memo(i + 3, n, nums);
        }
        if(i < n - 2 && nums[i + 1] == (nums[i] + 1) && nums[i + 2] == (nums[i + 1] + 1)){
            ans |= memo(i + 3, n, nums);
        }
        
        return dp[i] = ans;
    }
}