class Solution {
    //brute force
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int maxCount=0;
        for(int i=0;i<n;i++){
            int currCount=1;
            int j=i;
            while(j<n-1 && Math.abs(nums[j+1]-nums[j])<=1){
                
                if(j<n-1 && (nums[j+1]-nums[j])==0){
                    j++;
                    continue;
                }
                j++;
                currCount++;
            }
            i=j;
            maxCount=Math.max(currCount,maxCount);
        }
        return maxCount;
    }
}