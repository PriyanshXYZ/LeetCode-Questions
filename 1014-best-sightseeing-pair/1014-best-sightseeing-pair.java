class Solution {
    public int maxScoreSightseeingPair(int[] values) {

        int currProfit = 0;
        int res = 0;
        for(int i=0;i<values.length;i++){
            res = Math.max(res, currProfit + values[i] - i);
            currProfit = Math.max(currProfit , values[i] + i);
        }
        return res;
    }
}