class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int les=1;//lowest eating speed
        int hes=0;//highest eating speed
        for(int pile:piles){
            hes=Math.max(hes,pile);
        }
        
        while(les < hes){
            int eatingSpeed = (les + hes) / 2;
            
            //calculate hours required to eat
            int maxHrs = 0;
            
            for(int pile :piles){
            
                maxHrs += (pile + eatingSpeed - 1) / eatingSpeed;
            }
            
            if(maxHrs>h){
                les=eatingSpeed+1;
            }else{
                hes=eatingSpeed;
            }
        }
        return les;
    }
}