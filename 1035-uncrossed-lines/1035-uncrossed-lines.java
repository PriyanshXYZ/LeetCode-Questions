class Solution {
    Integer[][] dp;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        dp = new Integer[nums1.length][nums2.length];
        return recursion(0,0,nums1,nums2);
    }
    public int recursion(int idx1,int idx2, int[] nums1, int[] nums2){
        //base case
        if(idx1>=nums1.length || idx2>=nums2.length)return 0;
        
        if(dp[idx1][idx2]!=null)return dp[idx1][idx2];
        int ans = 0;
        if(nums1[idx1]==nums2[idx2]){
            int inc = 1 + recursion(idx1 + 1, idx2 + 1, nums1, nums2);
            // int exc = recursion();
            ans = Math.max(ans, inc);
        }else{
            int curr1 = recursion(idx1 + 1, idx2, nums1, nums2);
            int curr2 = recursion(idx1, idx2 + 1, nums1, nums2);
            ans = Math.max(curr1,curr2);
        }
        return dp[idx1][idx2] = ans;
    }
}