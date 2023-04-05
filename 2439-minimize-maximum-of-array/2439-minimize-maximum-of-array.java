class Solution {
    public int minimizeArrayValue(int[] nums) {
        long[] prefixsum=new long[nums.length];
        long ans=0;
        prefixsum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefixsum[i]=prefixsum[i-1]+nums[i];    
        }
        
        for(int i=0;i<nums.length;i++){
            ans=Math.max((prefixsum[i]+i)/(i+1),ans);
        }
        return (int)ans;
    }
}