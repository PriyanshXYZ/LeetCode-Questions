class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int minKIdx = -1, maxKIdx = -1, invalidIdx = -1;
        long ans = 0;
        
        for(int i = 0; i < n; i++){
            if(nums[i] < minK || nums[i] > maxK){
                invalidIdx = i;
            }else{
                if(nums[i] == minK) minKIdx = i;
                
                if(nums[i] == maxK) maxKIdx = i;
                
                ans = ans + Math.max(0, Math.min(maxKIdx, minKIdx) - invalidIdx);
            }
        }
        return ans;
    }
}