class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int t=0;
        int size=Integer.MAX_VALUE;
        int si=0;
        for(int ei=0;ei<nums.length;ei++){
            t+=nums[ei];
            
            while(t>=target){
                t-=nums[si];
                size=Math.min(ei-si+1,size);
                si++;
            }
            
            // if(t>=target){
            //     size=Math.min(ei-si+1,size);    
            // }
        }
        if(size==Integer.MAX_VALUE)return 0;
        return size;
    }
}