class Solution {
    /*

           0 1 2 3
      1(0) 0 1 0 0
      1(1) 1 0 1 0 
      1(2) 0 2 0 1
      1(3) 
      1(4)

    */
    // there are 2 options either add or subtract
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 1); // there is always a way to get 0!!
        int minSum=0;
        for(int num : nums){
            minSum -= num;
        }

        for(int num : nums){
            Map<Integer,Integer> currCache = new HashMap();
            for(var entry : cache.entrySet()){
                int val = entry.getKey();
                int count = entry.getValue();
                int takePositive = val - num;
                int takeNegative = val + num;

                currCache.put(takePositive,currCache.getOrDefault(takePositive, 0)+count);
                currCache.put(takeNegative,currCache.getOrDefault(takeNegative, 0)+count);
            }
            cache = currCache;
        }
        return cache.getOrDefault(target,0);
    }
}