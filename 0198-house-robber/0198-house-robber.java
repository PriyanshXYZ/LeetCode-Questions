class Solution {
    public int rob(int[] nums) {
        // return Math.max(f(0, nums, 0) /* rob */, f(0, nums, 1)/*dont rob*/);
        Integer[][] dp = new Integer[nums.length][2];
        return Math.max(f(0, nums, 0, dp) /* rob */, f(0, nums, 1, dp)/*dont rob*/);
    }
    
    public int f(int idx, int[] nums, int flag, Integer[][] dp){
        if(idx == nums.length)return 0;
        
        if(dp[idx][flag] != null )return dp[idx][flag];
        int ans=0;
        if(flag==1){//do not rob current house
            ans=f(idx + 1, nums, 0, dp);
        }else{
            int rob =nums[idx] + f(idx + 1, nums , 1, dp);
            int notRob = f(idx + 1, nums , 0, dp);
            ans=Math.max(rob, notRob);
        }
        return dp[idx][flag] = ans;
    }
    private int f(int idx, int[] nums, int flag){
        if(idx==nums.length)return 0;
        
        int ans=0;
        if(flag==1){//do not rob current house
            ans=f(idx + 1, nums, 0);
        }else{
            int rob =nums[idx] + f(idx + 1, nums , 1);
            int notRob = f(idx + 1, nums , 0);
            ans=Math.max(rob, notRob);
        }
        return ans;
    }
}
class Solution1 {
    public int rob(int[] nums) {
        // int[] dp=new int[nums.length+1];
        // Arrays.fill(dp,-1);
        // int ans=memo(0,nums.length,nums,dp);//rob current house
        // Arrays.fill(dp,-1);
        // ans=Math.max(memo(1,nums.length,nums,dp),ans);//dont rob
        // return ans;
        
        int rob=0,notrob=0;
        for(int i=0;i<nums.length;i++){
            int currRob=nums[i]+notrob;
            int currNotRob=Math.max(rob,notrob);
            rob=currRob;
            notrob=currNotRob;
        }
        return Math.max(rob,notrob);
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