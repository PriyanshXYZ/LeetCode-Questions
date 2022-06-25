class Solution {
    //O(n)
    public boolean checkPossibility(int[] nums) {
        int count=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                count++;
                if(count>1)return false;
                if(i>1 && i<nums.length-1 &&  nums[i-2]>nums[i] && nums[i+1]<nums[i-1])return false;
                
            }
        }
        return true;
    }
}