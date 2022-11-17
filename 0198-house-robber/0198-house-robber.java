class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        int ans=memo(0,nums.length,nums,dp);//rob current house
        Arrays.fill(dp,-1);
        ans=Math.max(memo(1,nums.length,nums,dp),ans);//dont rob
        return ans;
    }
    private int memo(int idx, int n, int[] nums, int[] dp){
        if(idx>=n)return 0;
        if(dp[idx]!=-1)return dp[idx];
        
        int ans=0;
        ans=nums[idx]+memo(idx+2,n,nums,dp);
        ans=Math.max(memo(idx+1,n,nums,dp),ans);
        return dp[idx]=ans;
    }
    private int recur(int idx,int n,int[] nums,boolean flag){//flag ==0 prev house not stolen ,prev house stolen
        if(idx==n)return 0;
        
        int ans=0;
        if(!flag){
            ans=nums[idx]+recur(idx+1,n,nums,!flag);
            ans=Math.max(recur(idx+1,n,nums,flag),ans);
        }else{
            ans=recur(idx+1,n,nums,!flag);
        }
        return ans;
    }
}