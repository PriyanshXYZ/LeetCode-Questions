class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1)return 0;
        int n = nums.length;
        int ans = 0;
        long sum = 1;
        int si = 0;
        for(int ei=0; ei<n; ei++){
            sum*=(long)nums[ei];
            while(si<n && sum>=k){
                sum/=nums[si];
                si++;
            }
            if(sum<k)
                ans += ei-si + 1;
        }
        
        return ans<0?0:ans;
    }
}