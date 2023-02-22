class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int lo = 0, hi = 0;
        for(int val : weights){
            hi += val;
            lo = Math.max(val, lo);
        }
        
        if(days >= n)return lo;
        
        int ans = -1;
        while(lo <= hi){
            int limit = lo + (hi - lo) / 2;
            
            int partitions=1;
            int sum=0;
            for(int wt : weights){
                if(sum+wt<=limit){
                    sum+=wt;
                }else{
                    partitions++;
                    sum=wt;
                }
            }
            
            if(partitions <= days){
                hi = limit - 1;
                ans = limit;
            }else{
                lo = limit + 1;
                
            }
        }
        return ans;
    }
}