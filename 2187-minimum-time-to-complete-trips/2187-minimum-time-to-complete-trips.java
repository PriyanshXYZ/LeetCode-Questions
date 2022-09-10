class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long lo=0;
        long hi=Long.MAX_VALUE/time.length;
        
        for(int val : time){
            lo=Math.min(val,lo);
        }
        
        while(lo < hi){
            long timeLimit=(lo+hi)/2;
            
            long trips=0;
            for(int t:time){
                trips+=timeLimit/t;
            }
            
            if(trips < totalTrips){
                lo=timeLimit+1;
            }else{
                hi=timeLimit;
            }
        }
        return lo;
    }
}