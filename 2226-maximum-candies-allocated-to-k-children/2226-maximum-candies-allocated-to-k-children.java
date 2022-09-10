class Solution {
    public int maximumCandies(int[] candies, long k) {
        long sum=0;
        long lo=1;
        long hi=0;
        for(int i=0;i<candies.length;i++){
            sum+=candies[i];
            hi=Math.max(candies[i],hi);
        }
        if(k>sum)return 0;
        
        while(lo<hi){
            long mid=lo+(hi-lo+1)/2;//for maximum possible value we use uppper bound of mid
            
            long size=0;
            for(int val:candies){
                
                long div = (val) / mid;

                size+=div;
                
            }
            
            if(size<k){
                hi=mid-1;
            }else{
                lo=mid;
            }
        }
        return (int)(lo);
    }
}