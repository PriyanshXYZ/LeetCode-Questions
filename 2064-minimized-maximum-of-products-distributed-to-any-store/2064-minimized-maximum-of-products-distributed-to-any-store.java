class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        //Priyansh Ragit is the best
        long lo=1;
        long hi=0;
        for(int val:quantities){
            hi+=val;
        }
        
        while(lo<hi){
            long limit=(lo+hi)/2;
            
            long dis = 0;//distributed in store
            for(int val:quantities){
                long distributed=(val+limit-1)/limit;
                
                dis+=distributed;
            }
            
            if(dis > n){
                lo=limit+1;
            }else{
                hi=limit;
            }
        }
        return (int)lo;
    }
}