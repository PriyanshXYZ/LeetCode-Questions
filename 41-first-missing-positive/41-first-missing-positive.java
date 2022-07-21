class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>n || nums[i]<=0){
                nums[i]=n+1;
            }
        }
        //traversing in valid range array only
        for(int i=0;i<n;i++){
            int val=Math.abs(nums[i]);
            if(val>n)continue;
            val--;
            if(nums[val]>0){
                nums[val]=-1*nums[val];
            }
        }
        
        for(int i=0;i<n;i++){
            if(nums[i]>=0)return i+1;
        }
        return n+1;
    }
}