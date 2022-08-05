class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        Arrays.fill(dp,-1);
        return memo(nums,dp,target);
    }
    
    private int memo(int[] a,int[] dp,int target){
        if(target==0){
            return dp[target]=1;
        }
        
        if(dp[target]!=-1)return dp[target];
        int ans = 0;
        for(int num:a){
            if(target-num >= 0){
                ans += memo(a ,dp ,target-num);
            }
        }
        return dp[target]=ans;
    }
}