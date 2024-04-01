class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        if(nums.length<2)return 1;
        long ans = 1;
        int ei = 1;
        int si = 0;
        while(ei < nums.length){
            if(nums[ei]!=nums[ei-1]){
                ans += ei - si + 1;
            }else{
                ans += 1;
                si = ei;
            }
            ei++;
        }
        
        return ans;
    }
}