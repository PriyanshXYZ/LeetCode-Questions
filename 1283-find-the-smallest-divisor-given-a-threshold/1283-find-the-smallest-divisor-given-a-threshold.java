class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1;
        int hi = 0;
        for( int i = 0 ; i < nums.length ; i++ ){
            hi = Math.max(hi , nums[i]);
        }
        
        while(lo < hi){
            int mid = (lo + hi) / 2;
            
            int sum = 0;
            
            for(int i = 0 ; i < nums.length ; i++){
                sum += (nums[i] + mid - 1) / mid; // here mid - 1 is used to give ceil value of divsion by mid
            }
            
            if(sum > threshold){ //sum is more which means we need to increase divisor
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return lo;
    }
}