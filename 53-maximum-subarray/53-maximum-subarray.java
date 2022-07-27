class Solution {
    public int maxSubArray(int[] nums) {
         //kadane's algorithm
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            max=Math.max(sum,max);
            
            if(sum<0) sum=0;
        }
        return max;
    }
    
}