class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long lo=Integer.MAX_VALUE;
        
        for(int val : time){
            lo=Math.min(val,lo);
        }
        long hi=lo*totalTrips;
        
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