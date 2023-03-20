class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        //appraoch is to fill max possible number of 1's in subarray of only zero having boundary of 1 
        
        int count = 1;
        int result = 0;
        for(int i=0; i<flowerbed.length; i++) {
            if(flowerbed[i] == 0) {
                count++;
            }else {
                result += (count-1)/2;
                count = 0;
            }
        }
        if(count != 0) result += count/2;
        return result>=n;
    }
}