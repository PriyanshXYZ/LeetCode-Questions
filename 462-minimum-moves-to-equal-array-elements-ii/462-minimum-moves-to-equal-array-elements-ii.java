class Solution {
    public int minMoves2(int[] nums) {
        if(nums.length==1)return 0;
        int prev=0;
        long minDiffSum=Integer.MAX_VALUE;
        
        for(int i=0;i<nums.length;i++){
            prev=nums[i];
            long currDiff=0;
            for(int j=0;j<nums.length;j++){
                
                    if(nums[j]-prev>=0){
                        currDiff+=nums[j]-prev;
                    }else{
                        currDiff+=prev-nums[j];
                    }
            }
            
            
            minDiffSum=Math.min(currDiff,minDiffSum);
        }
        return (int)minDiffSum;
    }
}