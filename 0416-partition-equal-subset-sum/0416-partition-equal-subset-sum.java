class Solution {
    int sum;
    public boolean canPartition(int[] nums) {
        sum=0;
        for(int val:nums){
            sum+=val;
        }
        if(sum%2!=0)return false;
        int dp[][]=new int[nums.length+1][sum+1];
        for(int i=0;i<nums.length;i++)Arrays.fill(dp[i],-1);
        // return recursion(0,0,nums.length,sum,nums);
        return  memo(nums.length-1,sum,nums,dp);
    }
    public boolean recursion(int idx,int sum,int n,int maxSum,int[] nums){
        if((maxSum-sum)==sum)return true;
        
        boolean ans=false;
        //include
        if(idx+1<n){
            ans|=recursion(idx+1,sum+nums[idx],n,maxSum,nums);
            ans|=recursion(idx+1,sum,n,maxSum,nums);
        }
        return ans;
    }
    public boolean memo(int n,int target,int[] nums,int[][] dp){
        if(n<0 || target<0)return false;
        if(n>=0 && target==sum/2){
            dp[n][target]=1;
            return true;
        }
        
        if(dp[n][target]!=-1){
            if(dp[n][target]==0)return false;
            return true;
        }
        
        boolean ans=false;
        if(nums[n]<=sum){
            ans|=memo(n-1,target-nums[n],nums,dp);//include
            ans|=memo(n-1,target,nums,dp);//exclude
        }else{
            ans|=memo(n-1,target,nums,dp);//exclude
        }
        
        dp[n][target]=ans?1:0;
        return ans;
    }
}