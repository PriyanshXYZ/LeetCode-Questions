class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        
        int max = 0;
        for(int cost : costs){
            if(coins - cost >= 0){
                max++;
                coins -= cost;
            }else break;
        }
        return max;
    }
}