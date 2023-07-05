class Solution {
    public int longestSubarray(int[] nums) {
        int size = 0;
        int si = 0;
        int zeroCnt = 0;
        for(int ei=0;ei<nums.length;ei++){
            if(nums[ei] == 0){
                zeroCnt++;
            }
            while(zeroCnt > 1){
                if(nums[si]==0){
                    zeroCnt--;
                }
                si++;
            }
            
            size = Math.max(size, ei - si);
        }
        return size;
    }
}