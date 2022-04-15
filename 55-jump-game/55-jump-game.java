class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length<2)return true;
        int[] dp=new  int[nums.length];
        Arrays.fill(dp,-1);
        return memo(0,nums,dp,nums.length-1);
    }
    public boolean recursion(int idx,int[] nums,int n){
        if(idx>=n)return true;
        
        boolean ans=false;
        for(int jumps=1;jumps<=nums[idx];jumps++){
            ans|=recursion(idx+jumps,nums,n);
        }
        return ans;
    }
    public boolean memo(int idx,int[] nums,int[] dp,int n){
        if(idx>=n){
            dp[n]=1;
            return true;
        }
        if(nums[idx]==0){
            dp[idx]=0;
            return false;
        }
        if(dp[idx]!=-1)return dp[idx]==1;
        boolean ans=false;
        for(int jumps=1;jumps<=nums[idx];jumps++){
            if(memo(idx+jumps,nums,dp,n)){
                dp[idx]=1;
                return true;
            }
        }
        dp[idx]=0;
        return false;
    }
}
