class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        
        long[] pre = new long[n+1];
        
        for(int i=0;i<n;i++){
            pre[i+1] = pre[i] + nums[i];
        }
        
        
        
        for(int i=k;i<n-k;i++){
            long ans = (pre[i+k+1] - pre[i-k]);
            res[i] = (int)((ans) / (long)(2*k +1));
        }
        return res;
    }
}