class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        if(n == 1)return 0;
        int count = 0;
        int[] freq = new int[101];
        int i=n-1;
        for(;i>=0;i--){
            int val = ++freq[nums[i]];
            if(val>1){
                break;
            }
        }
        return (i+3) / 3;
    }
}