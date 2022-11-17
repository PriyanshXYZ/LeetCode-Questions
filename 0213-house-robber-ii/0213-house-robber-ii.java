class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        int ans1=0;
        int rob=0,notrob=0;
        for(int i=0;i<n-1;i++){
            int currRob=nums[i]+notrob;
            notrob=Math.max(rob,notrob);
            rob=currRob;
        }
        ans1=Math.max(rob,notrob);
        
        int ans2=0;
        rob=0;
        notrob=0;
        for(int i=1;i<n;i++){
            int currRob=nums[i]+notrob;
            notrob=Math.max(rob,notrob);
            rob=currRob;
        }
        ans2=Math.max(rob,notrob);
        return Math.max(ans1,ans2);
    }
}