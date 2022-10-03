class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if(n<m*k){
            return -1;
        }else if(n==m*k){
            int max=0;
            for(int val:bloomDay)max=Math.max(val,max);
            return max;
        }else{
            int lo=Integer.MAX_VALUE;
            int hi=Integer.MIN_VALUE;
            for(int val:bloomDay){
                lo=Math.min(lo,val);
                hi=Math.max(hi,val);
            }
            
            while(lo<hi){
                int days=lo+(hi-lo)/2;
                
                int bloom=0;
                int bouquets=0;
                for(int val:bloomDay){
                    if(val > days){
                        bloom=0;
                        continue;
                    }
                    bloom++;
                    if(bloom>=k){
                        bouquets++;
                        bloom=0;
                    }
                }
                
                if(bouquets < m){
                    lo=days+1;
                }else{
                    hi=days;
                }
            }
            return lo;
        }
    }
}