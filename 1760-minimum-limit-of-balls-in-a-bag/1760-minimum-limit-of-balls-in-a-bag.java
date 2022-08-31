class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int lms = 1;//lowest maximum size of bag
        int hms = Integer.MIN_VALUE;//highest maximum size of bag
        for(int num : nums){
            hms = Math.max(num,hms);
        }
        
        while(lms < hms){
            int limitSize=(lms + hms) / 2;
            
            //get count of smallest possible limit
            int maxSize=0;
            for(int num:nums){
                if(num > limitSize){
                    int opn = (num) / limitSize;//operation
                    
                    if(num % limitSize == 0)opn--;
                    maxSize += opn;
                }
            }
            
            if(maxSize> maxOperations){
                lms = limitSize + 1;
            }else {
                hms = limitSize;
            }
        }
        return lms;
    }
}