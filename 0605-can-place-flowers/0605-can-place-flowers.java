class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        //appraoch is to fill max possible number of 1's in subarray of only zero having boundary of 1 
        
        int count = 1;
        int max = 0;
        for(int i  = 0;i<flowerbed.length;i++){
            if(flowerbed[i]==1){
                max += (count - 1)/ 2;
                count = 0;
            }else{
                count++;
            }
        }
        if(count!=0)max += count/2;
        return max>=n;
    }
}