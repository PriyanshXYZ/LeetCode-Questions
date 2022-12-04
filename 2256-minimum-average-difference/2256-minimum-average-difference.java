class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n=nums.length;
        long[] prefix=new long[n+1];
        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+nums[i];
        }
        
        long minDiff=prefix[n]/n;
        int minIdx=n-1;
        
        for(int i=n-1;i>0;i--){
            long diff=Math.abs(prefix[i]/i-(prefix[n]-prefix[i])/(n-i));
            // System.out.println(diff);
            if(diff<=minDiff){
                minDiff=diff;
                minIdx=i-1;
                // System.out.println(minDiff+" "+minIdx);
            }   
        }
        return minIdx;
    }
}