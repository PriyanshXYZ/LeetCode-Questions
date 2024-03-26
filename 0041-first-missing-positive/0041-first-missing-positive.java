class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        for(int i=0;i<n;i++){
            int num = nums[i];
            if(num > n || num<=0){
                nums[i] = n + 1;
            }
        }
        for(int i=0;i<n;i++){
            int val = Math.abs(nums[i]);
            
            if(val>n)continue;
            
            val--;
            
            if(nums[val]>0){
                nums[val] = -1*nums[val];
            }
        }
        
        for(int i=0;i<n;i++){
            int val = nums[i];
            if(val>=0)return i+1;
        }
        return n+1;
    }
}