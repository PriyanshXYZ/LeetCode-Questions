class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        k = n - k;

        //reverse both subarray
        // reverse whole array
        reverse(0, k - 1, nums);
        reverse(k, n - 1, nums);
        reverse(0, n - 1, nums);
    }

    private void reverse(int i, int j, int[] nums) {
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
    }
}