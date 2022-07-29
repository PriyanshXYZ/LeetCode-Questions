class Solution {
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        int mod=(int)(1e9+7);
        int n=nums.length;
        long ans=0;
        long p=1;
        for(int i=0;i<n;i++){
            ans=(ans + p*nums[i] - p*nums[n-1-i])%mod;
            p=p*2%mod;
        }
        ans=ans%mod;
        return (int)ans;
    }
}