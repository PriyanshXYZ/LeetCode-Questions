class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int maxPrefix = 0;
        int maxDiff = 0;
        long product = 0;
        for(int i=0;i<n;i++){
            product = Math.max((long)(maxDiff)*(long)nums[i], product);
            maxDiff = Math.max(maxDiff, maxPrefix - nums[i]);
            maxPrefix = Math.max(nums[i],maxPrefix);
        }
        return product;
    }
}

class Solution1 {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];

        for(int i=1;i<n;i++){
            prefixMax[i] = Math.max(prefixMax[i-1],nums[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            suffixMax[i] = Math.max(suffixMax[i+1],nums[i+1]);
        }
        long ans = 0;
        for(int i=1;i<n;i++){
            ans = Math.max((long)(prefixMax[i]-nums[i])*(long)suffixMax[i], ans);
        }
        return ans;
    }
}