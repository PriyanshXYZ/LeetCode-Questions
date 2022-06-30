class Solution {
    //O(nlogn)
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        int median=nums[nums.length/2];
        for(int num:nums){
            ans+=Math.abs(num-median);
        }
        return ans;
    }
}
class Solution1 {
    //O(n)^2
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