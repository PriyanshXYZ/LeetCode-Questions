class Solution {
    int ans;
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        ans = 0;
        recursion(0,nums,0);
        return ans;
    }

    private void recursion(int idx, int[] nums, int xor){
        if(idx==nums.length){
            ans += xor;
            return;
        }

        recursion(idx+1,nums,xor^nums[idx]);
        recursion(idx+1,nums,xor);
    }
}