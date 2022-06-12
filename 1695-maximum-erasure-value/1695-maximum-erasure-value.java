class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int sum=0;
        int maxSum=0;
        int count=0;
        Set<Integer> set=new HashSet();
        for(int l=0,r=0;r<nums.length;r++){
            sum+=nums[r];
            
            while(!set.add(nums[r])){
                sum-=nums[l];
                set.remove(nums[l++]);
            }
            set.add(nums[r]);
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;
    }
}