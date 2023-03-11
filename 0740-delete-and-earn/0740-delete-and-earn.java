class Solution {
    public int deleteAndEarn(int[] nums) {
        //problem boils down to whether we need to earn current element or we need not earn it
        //we can make a earning all togther in our list..
        int[] values = new int[10001];
        
        for(int val : nums){
            values[val]+=val;
        }
        
        int take = values[1];
        int notTake = 0;
        for(int i=2;i<values.length;i++){
            int currTake = values[i] + notTake;
            int currNotTake = Math.max(take, notTake);
            take = currTake;
            notTake = currNotTake;
        }
        return Math.max(take,notTake);
    }
}