class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] prefix = new int[nums.length+1];
        int[] suffix = new int[nums.length+1];
        
        for(int i = 0; i < nums.length; i++){
            prefix[i+1] = prefix[i] + nums[i];
        }
        
        for(int i = nums.length - 1; i >= 0; i--){
            suffix[i] = suffix[i + 1] + nums[i];
        }
        int[] res = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            res[i] = (nums[i] * i) - prefix[i+1] + suffix[i] - (nums[i] * (nums.length - i - 1));
        }
        
        return res;
    }
}