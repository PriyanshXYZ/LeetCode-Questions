class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int lms = 1;//lowest maximum size of bag
        int hms = Integer.MIN_VALUE;//highest maximum size of bag
        for(int num : nums){
            hms = Math.max(num,hms);
        }
        
        while(lms<hms){
            int limit=lms+(hms-lms)/2;
            
            int oprtn=0;
            
            for(int val:nums){
                if(val>limit){
                    int opn= (val)/limit;
                    
                    if(val%limit==0)opn--;
                    oprtn+=opn;
                }
            }
            
            if(oprtn>maxOperations){
                lms=limit+1;
            }else{
                hms=limit;
            }
        }
        
        return lms;
    }
}