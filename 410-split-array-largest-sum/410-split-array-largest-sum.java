class Solution {
    public int splitArray(int[] nums, int m) {
        int lo=Integer.MIN_VALUE;
        int hi=0;
        for(int num:nums){
            hi+=num;
            lo=Math.max(lo,num);
        }
        
        //binary search on answer
        while(lo<hi){
            int val=lo+(hi-lo)/2;
            
            int partitions=1;
            int maxSum=0;
            for(int num:nums){
                if(maxSum+num <=val){
                    maxSum+=num;
                }else{
                    maxSum=num;
                    partitions++;
                }
            }
            
            if(partitions > m){//partitions are more we need to take bigger maxSum
                lo=val+1;
            }else{
                hi=val;
            }
        }
        
        return lo;
    }
}