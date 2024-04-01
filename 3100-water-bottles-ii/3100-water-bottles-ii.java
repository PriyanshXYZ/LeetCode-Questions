class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int sum = numBottles;
        int currLeft = numBottles;
        while(numExchange<currLeft){
            currLeft = (currLeft-numExchange);
            sum += 1;
            currLeft += 1;
            numExchange += 1;
        }
        return numExchange==currLeft?sum+1:sum;
    }
}