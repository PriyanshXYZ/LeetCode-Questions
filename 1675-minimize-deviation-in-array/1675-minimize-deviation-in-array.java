class Solution {
    public int minimumDeviation(int[] nums) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int minVal = Integer.MAX_VALUE;
        //try to get minVal
        for(int num : nums){
            if(num%2==1){
                num*=2;
            }
            pq.add(num);
            minVal = Math.min(minVal, num);
        }
        
        int deviation = Integer.MAX_VALUE;
        int maxVal = 0;
        while(true){
            maxVal = pq.remove();
            
            deviation = Math.min(deviation, maxVal - minVal);
            
            if(maxVal%2==1)return deviation;
            
            maxVal = maxVal/2;
            
            minVal = Math.min(maxVal, minVal);
            
            pq.add(maxVal);
        }
        
    }
    
}