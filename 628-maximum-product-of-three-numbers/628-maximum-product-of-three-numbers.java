class Solution {
    public int maximumProduct(int[] nums) {
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int max3=Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            if(val>max1){
                max3=max2;
                max2=max1;
                max1=val;
            }else if(val>max2){
                max3=max2;
                max2=val;
            }else if(val>max3){
                max3=val;
            }
            
            if(val<min1){
                min2=min1;
                min1=val;
            }else if(val<min2){
                min2=val;
            }
        }
        return Math.max(min1*min2*max1,max1*max2*max3);
    }
}