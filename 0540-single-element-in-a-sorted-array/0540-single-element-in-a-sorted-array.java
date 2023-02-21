class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0];
        int lo = 0,hi = n-1;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            
            if(mid%2==1){
                mid-=1;
            }
            if(nums[mid]==nums[mid+1])lo=mid+2;
            else hi = mid;
        }
        return nums[lo];
    }
}