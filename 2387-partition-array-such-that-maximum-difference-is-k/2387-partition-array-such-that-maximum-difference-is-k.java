class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int prev=0;
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[prev]>k){
                count++;
                prev=i;
            }
        }
        return count;
    }
}