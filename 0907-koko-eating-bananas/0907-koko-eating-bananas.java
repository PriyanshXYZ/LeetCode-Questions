class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = 0;
        
        for(int val : piles){
            maxSpeed = Math.max(maxSpeed, val);
        }

        while(minSpeed < maxSpeed){
            int currSpeed = minSpeed + (maxSpeed - minSpeed) / 2;
            
            int hours = 0;
            for(int val : piles){
                hours += (val) / currSpeed;
                if(val%currSpeed!=0){
                    hours++;
                }
            }
            
            if(hours > h){
                minSpeed = currSpeed + 1;
            }else{
                maxSpeed = currSpeed;
            }
        }
        return minSpeed;
    }
}