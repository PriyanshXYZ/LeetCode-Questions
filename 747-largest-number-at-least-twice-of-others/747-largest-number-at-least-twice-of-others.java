class Solution {
    public int dominantIndex(int[] nums) {
        int max=Integer.MIN_VALUE;
        int secMax=Integer.MIN_VALUE;
        int idx1=-1;
        int idx2=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                secMax=max;
                idx2=idx1;
                max=nums[i];
                idx1=i;
            }else if(nums[i]>secMax){
                secMax=nums[i];
                idx2=i;
            }
        }
        if(idx1!=-1 && idx2!=-1){
            if(max>=2*secMax)
                return idx1;
        }
        return -1;
    }
}