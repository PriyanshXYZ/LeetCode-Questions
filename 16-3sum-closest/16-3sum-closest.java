class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int closest=0;
        
        int minDiff=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j=i+1,k=n-1;
            while(j<k){
                int val=nums[i]+nums[j]+nums[k];
                if(Math.abs(target-val)<minDiff){
                    minDiff=Math.abs(target-val);
                    if(val==target)return target;
                    closest=val;
                }
                
                if(val>target){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return closest;
    }
}