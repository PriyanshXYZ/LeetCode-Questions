class Solution {
    //approach 1 => using 3 loops n^3
    //approach 2 => keep a prefix sum of elements and now we require only 2 loops n^2
    //appraoch 3 kadane's
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