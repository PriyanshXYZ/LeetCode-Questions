class Solution {
    public int lengthOfLIS(int[] nums) {
        int lis=0;
        
        int n=nums.length;
        int[] dp=new int[n];
        
        for(int i=0;i<n;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(dp[j]>max){
                        max=dp[j];
                    }
                }
            }
            dp[i]=max+1;
            
            lis=Math.max(lis,dp[i]);
        }
        return lis;
    }
}