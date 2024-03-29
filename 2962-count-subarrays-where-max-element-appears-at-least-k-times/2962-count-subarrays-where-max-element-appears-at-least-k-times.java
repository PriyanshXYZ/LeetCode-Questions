class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        int n = nums.length;
        for(int num : nums)max = Math.max(max,num);
        int si = 0;
        long ans = 0;
        int cnt = 0;
        //find all subarray with max < k .. thats pretty easy
        for(int i=0;i<n;i++){
            if(max==nums[i])cnt++;
            while(cnt>=k){
                if(nums[si]==max)cnt--;
                si++;
            }
            ans += i - si + 1;
        }
        return (long)n*(long)(n+1)/2 - (long)ans;
    }
}